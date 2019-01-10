package com.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.bean.Msproductdetail;
import com.cache.MsproductdetailServiceCache;
import com.common.BaseController;
import com.redis.MsproductdetailRedisService;
import com.service.MsproductdetailService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;


/**
 * @classname:
 * @description:
 * @author: zhuyuchao
 * @date: 2018/12/5 19:04
 * @version: 1.0
 **/
@Controller
@RequestMapping("msproductdetail")
public class MsproductdetailController extends BaseController {
    final static Logger logger=Logger.getLogger(MsproductdetailController.class);
    @Autowired(required=false)
    private MsproductdetailService msproductDetailService;

    @Autowired(required=false)
    private MsproductdetailRedisService msproductdetailRedisService;

    @RequestMapping(value="toinsertMsproductdetail")
    public String toinsertMsproductdetail(HttpServletRequest req, int productid, int merchantid){
        req.setAttribute("productid", productid);
        req.setAttribute("merchantid", merchantid);
        logger.info(productid+"----"+merchantid);
        return "msproductDetail/toinsertMsproductdetail";
    }

    @RequestMapping(value="insertMsproductdetail",method= RequestMethod.POST)
    public String insertMsproductdetail(Msproductdetail msproductdetail){
        logger.info(msproductdetail);
        msproductDetailService.insert(msproductdetail);
        return "redirect:/msproductinfo/listmsproduct";
    }


//使用Ehcache缓存查询
    @RequestMapping(value="queryMsproductdetailByid")
    public String queryMsproductdetailByid(HttpServletRequest req,int productid){
        Msproductdetail msproductdetail = msproductdetailRedisService.queryMsproductdetailByid(productid);
        req.setAttribute("msproductdetail", msproductdetail);
        return "msproductDetail/msproductdetailview";
    }

    @RequestMapping(value="toupdateMsproductdetail")
    public String toupdateMsproductdetail(HttpServletRequest req,int productid){
        Msproductdetail msproductdetail = msproductDetailService.queryMsproductdetailByid(productid);
        req.setAttribute("msproductdetail", msproductdetail);
        return "msproductDetail/toupdateMsproductdetail";
    }

    @RequestMapping(value="updateMsproductdetail",method=RequestMethod.POST)
    public String updateMsproductdetail(HttpServletRequest req,Msproductdetail msproductdetail){
        msproductDetailService.updateMsproductdetail(msproductdetail);
        return "redirect:/msproductinfo/listmsproduct";
    }
}
