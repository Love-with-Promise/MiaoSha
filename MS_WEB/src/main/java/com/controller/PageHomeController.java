package com.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.bean.Msproductdetail;
import com.bean.Msproductinfo;
import com.bean.Msuser;
import com.common.BaseController;
import com.service.MsproductdetailService;
import com.service.MsproductinfoService;
import com.vo.ConstomProduct;
import com.vo.MsProductVo;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @classname:
 * @description:
 * @author: zhuyuchao
 * @date: 2018/12/6 19:37
 * @version: 1.0
 **/
@Controller
@RequestMapping("pagehomeAction")
public class PageHomeController extends BaseController {
    private Logger logger=Logger.getLogger(PageHomeController.class);

    @Autowired(required=false)
    private MsproductinfoService msproductService;

    @Autowired(required=false)
    private MsproductdetailService msproductdetailService;

    @RequestMapping("tohome")
    public String tohome(HttpServletRequest req){
        MsProductVo msProductVo = new MsProductVo();
        ConstomProduct constomProduct = new ConstomProduct();
        Date now = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowstring = dateFormat.format(now);
        constomProduct.setStartendtime(nowstring);
        constomProduct.setAuditstate(2);
        msProductVo.setConstomProduct(constomProduct);
//		private Date startstarttime;//秒杀开始时间查询范围开始时间
//		private Date endstarttime;//秒杀开始时间查询范围结束时间
        msProductVo.setConstomProduct(constomProduct);
        logger.info("-------***"+msProductVo);
        List<Msproductinfo> list = msproductService.listmsproduct(msProductVo);
        req.setAttribute("list", list);
        logger.info("-------***"+list.size());
        return "homepage/homepage";
    }

    @RequestMapping("viewproductdetail")
    public String viewproductdetail(HttpServletRequest req,int id){
        Msproductinfo msproduct = msproductService.selectByPrimaryKey(id);
        Msproductdetail msproductdetail = msproductdetailService.queryMsproductdetailByid(id);
        req.setAttribute("msproduct", msproduct);
        req.setAttribute("msproductdetail", msproductdetail);
        return "order/selldetail";
    }

    //生成频道列表静态化页面
    @RequestMapping("producehtml")
    public void producehtml(HttpServletRequest req){
        String htmlPath=req.getRealPath("/WEB-INF/html/");
        String contextpath = req.getScheme() +"://" + req.getServerName()  + ":" +req.getServerPort() +req.getContextPath();
        contextpath = contextpath + "/pagehomeAction/tohome";
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(contextpath);
        CloseableHttpResponse response = null;
        try {
            //3.执行请求，获取响应
            response = client.execute(httpGet);
            //看请求是否成功，这儿打印的是http状态码
            System.out.println(response.getStatusLine().getStatusCode());
            //4.获取响应的实体内容，就是我们所要抓取得网页内容
            HttpEntity entity = response.getEntity();
            //5.将其打印到控制台上面
            //方法一：使用EntityUtils
            if (entity != null) {
                String html = EntityUtils.toString(entity);
                File file = new File(htmlPath+"/index.html");//存到应用的htmlPath目录下
                Writer writer = new BufferedWriter(
                        new OutputStreamWriter(
                                new FileOutputStream(file), "utf-8"));
                writer.write(html);
                writer.flush();
                writer.close();
            }
            EntityUtils.consume(entity);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }


    @RequestMapping("producejs")
    public void producejs(HttpServletRequest req){
        String jsPath=req.getRealPath("/WEB-INF/classes/js");
        String jscontent = "function remaintime(){" + "\n" +
                "var starttime = $(\"#starttime\").html();" +"\n" +
                "var s1 = new Date(starttime.replace(\"/-/g\",\"/\"));"+"\n" +
                "var s2 = new Date();"+"\n" +
                "var date3 = s1.getTime() - s2.getTime();//这是一个相差时间戳" +"\n" +
                "if(date3 > 2){"+"\n" +
                "$(\"#sellbnt\").attr({\"disabled\":\"disabled\"});" +"\n" +
                "var days = Math.floor(date3/(24*3600*1000));" +"\n" +
                "var leave = date3%(24*3600*1000)"+"\n" +
                "var hours = Math.floor(leave/(3600*1000));"+"\n" +
                "var leave1 = leave%(3600*1000)"+"\n" +
                "var minutes = Math.floor(leave1/(60*1000));"+"\n" +
                "var leave2 = leave1%(60*1000)"+"\n" +
                "var seconds = Math.floor(leave2/1000)"+"\n" +
                "$(\"#remainnoties\").html(\"相差 \"+days+\" 天\"+ hours + \" 小时\" + minutes + \" 分钟\"+seconds+\"秒\");" +"\n" +
                "}else{" + "\n" +
                "$(\"#remainnoties\").html(\"\");" + "\n" +
                "$(\"#sellbnt\").removeAttr(\"disabled\");" +"\n" +
                "$(\"#sellbnt\").parent().attr(\"action\",\"/orderAction/topayorder\");" +"\n" +
                "}" + "\n" +
                "}" +"\n" +
                "// test js new "+"\n" +
                "setInterval('remaintime()',500);";
        File file = new File(jsPath+"/remain.js");//存到应用的htmlPath目录下
        Writer writer = null;
        try {
            writer = new BufferedWriter(
                    new OutputStreamWriter(
                            new FileOutputStream(file), "utf-8"));
            writer.write(jscontent);
            writer.flush();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            if (writer != null)
                try {
                    writer.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
        }

    }


    @RequestMapping("getuser")
    @ResponseBody
    public String getUser(HttpServletRequest request){
        HttpSession session=request.getSession();
        Msuser msuser= (Msuser) session.getAttribute("msuser");
        String account="";
        if (msuser!=null){
            account=msuser.getUsername();
        }
        return  account;
    }
}
