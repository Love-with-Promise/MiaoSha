package com.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.bean.Msmerchant;
import com.bean.Msorder;
import com.bean.Msproductinfo;
import com.bean.Msuser;
import com.common.BaseController;
import com.pay.WeiXinPay;
import com.pay.YinLianPay;
import com.pay.ZhiFuBaoPay;
import com.redis.MsproductinfoRedisService;
import com.redis.OrderRedisService;
import com.service.MsorderService;
import com.service.MsproductinfoService;
import com.service.PayOrderService;
import com.vo.ConstomOrder;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @classname:
 * @description:
 * @author: zhuyuchao
 * @date: 2018/12/5 19:03
 * @version: 1.0
 **/
@Controller
@RequestMapping("orderAction")
public class MsorderController extends BaseController {
    final static Logger logger=Logger.getLogger(MsorderController.class);
    @Autowired(required=false)
    MsorderService msoderService;

    @Autowired(required=false)
    MsproductinfoService msproductService;

    @Autowired(required=false)
    private MsproductinfoRedisService msproductinfoRedisService;

    @Autowired(required=false)
    private OrderRedisService orderRedisService;

    @Autowired(required = false)
    ZhiFuBaoPay zhiFuBaoService;

    @Autowired(required = false)
    WeiXinPay weiXinService;

    @Autowired(required = false)
    YinLianPay yinLianService;

    @RequestMapping(value = "payorder", method = RequestMethod.POST)
    public String payorder(HttpServletRequest request,ConstomOrder msorder) {
        String returnurl="redirect:/pagehomeAction/tohome";
        HttpSession session=request.getSession();
        Msuser msuser= (Msuser) session.getAttribute("msuser");
        if (msuser!=null){
           Map<String,Object> map= orderRedisService.seckill(msuser.getId(),msorder.getProductid(),msorder);
           boolean isSuccess= (Boolean) map.get("success");
           if (isSuccess){
               System.out.println("秒杀成功");
               Map<String,String> datamap= (Map<String, String>) map.get("datamap");
               String merchantid=datamap.get("merchantid");
               String payamount=datamap.get("payamount");
               String tradeserialnumber=datamap.get("tradeserialnumber");
               String productid=datamap.get("productid");
               String userid=datamap.get("userid");
               returnurl="redirect:topaywithorder?userid="+userid+"&&productid="+productid+"&&tradeserialnumber="+tradeserialnumber+"&&payamount="+payamount+"&&merchantid="+merchantid;
           }else {
               System.out.println("秒杀失败");
           }
        }else {
            request.setAttribute("error","未登录");
             returnurl="user/tologin";
        }
        return returnurl;

    }


    @RequestMapping("topayorder")
    public String topayorder(HttpServletRequest req, int id, int num) {
        Msproductinfo msproductinfo = msproductinfoRedisService.selectByPrimaryKey(id);
        req.setAttribute("msproductinfo", msproductinfo);
        req.setAttribute("productnum", num);
        int payamount = num * msproductinfo.getMiaoshaprie();
        req.setAttribute("payamount", payamount);
        HttpSession sess = req.getSession();
        Msuser msuser = (Msuser) sess.getAttribute("msuser");
        if (msuser != null) {
            req.setAttribute("msuserid", msuser.getId());
        } else {
            req.setAttribute("error", "未登录");
            return "user/tologin";
        }
        return "order/payorder";
    }

    @RequestMapping("queryorderbyuserid")
    public String userOrder(HttpServletRequest request) {
        String url = "order/listOrder";
        HttpSession session = request.getSession();
        Msuser msuser = (Msuser) session.getAttribute("msuser");
        if (msuser != null) {
            List<Msorder> list = orderRedisService.queryorderbyuserid(msuser.getId());
            request.setAttribute("list", list);
        } else {
            request.setAttribute("error", "未登录，请登录");
            url = "user/tologin";
        }
        return url;
    }

    /**
     * 跳转到支付页面
     * @param req
     * @param tradeserialnumber
     * @param payamount
     * @return
     */
    @RequestMapping("topaywithorder")
    public String topaywithorder(HttpServletRequest req,int userid,int productid,int merchantid,String tradeserialnumber, int payamount){
        req.setAttribute("userid", userid);
        req.setAttribute("productid",productid);
        req.setAttribute("merchantid",merchantid);
        req.setAttribute("tradeserialnumber", tradeserialnumber);
        req.setAttribute("payamount", payamount);
        return "order/payreal";


    }

    /**
     * 选择支付方式
     * @param tradeserialnumber
     * @param payamount
     * @param paytype
     * @return
     */
    @RequestMapping(value = "paywithorder",method = RequestMethod.POST)
    public String payToOrder( HttpServletRequest req,int paytype,int userid,int productid,int merchantid,String tradeserialnumber, int payamount) {
        int payStatus = 2;
        if (paytype==1) {
            payStatus = zhiFuBaoService.payToOrder(tradeserialnumber, payamount);
        } else if (paytype==2) {
            payStatus = weiXinService.payToOrder(tradeserialnumber, payamount);
        } else if (paytype==3) {
            payStatus = yinLianService.payToOrder(tradeserialnumber, payamount);
        }

        if (payStatus == 1) {
            boolean isSuccess=orderRedisService.payorder(paytype,userid,productid,merchantid,tradeserialnumber,payamount);
            if (isSuccess){
                System.out.println("支付成功");
            }else {
                System.out.println("支付失败");
            }
        }
        return "redirect:queryorderbyuserid";
    }

    @RequestMapping("applyrefund")
    public String applyrefund(HttpServletRequest req,int orderid,int paytype){
        String returnurl = "redirect:queryorderbyuserid";
        HttpSession sess = req.getSession();
        Msuser msuser = (Msuser) sess.getAttribute("msuser");
        if(msuser!=null){
            msoderService.updateorderpaystatusbyid(4, orderid, paytype);
        }else{
            req.setAttribute("error", "未登陆");
            returnurl = "user/tologin";
        }

        return returnurl;
    }


    @RequestMapping("auditrefund")
    public String auditrefund(HttpServletRequest req,String tradeserialnumber,int payamount,int orderid,int paytype,int paystatus){
        String returnurl = "redirect:queryorderbyMsmerchanid";
        HttpSession sess = req.getSession();
        Msmerchant msmerchant = (Msmerchant) sess.getAttribute("msmerchant");
        if(msmerchant!=null){
            if(paystatus == 3){
                int paystatustemp = 2;
                if(paytype == 1){//1代表支付宝
                    paystatustemp = zhiFuBaoService.refundwithorder(tradeserialnumber, payamount);
                }else if(paytype == 2){//2代表微信
                    paystatustemp = weiXinService.refundwithorder(tradeserialnumber, payamount);
                }else if(paytype == 3){//3是代表银联
                    paystatustemp = yinLianService.refundwithorder(tradeserialnumber, payamount);
                }
                if(paystatustemp == 1){
                    msoderService.updateorderpaystatusbyid(paystatus, orderid, paytype);
                }

            }else if(paystatus == 5){
                msoderService.updateorderpaystatusbyid(paystatus, orderid, paytype);
            }
        }else{
            req.setAttribute("error", "未登陆");
            returnurl = "msmerchant/tologin";
        }

        return returnurl;
    }
}
