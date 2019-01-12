package com.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.bean.Msproductinfo;
import com.cache.MsproductinfoServiceCache;
import com.common.BaseController;
import com.redis.MsproductinfoRedisService;
import com.service.MsproductinfoService;
import com.util.DateUtil;
import com.vo.MsProductVo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @classname:
 * @description:
 * @author: zhuyuchao
 * @date: 2018/12/5 19:04
 * @version: 1.0
 **/
@Controller
@RequestMapping("msproductinfo")
public class MsproductinfoController extends BaseController {
    final static Logger logger= Logger.getLogger(MsproductinfoController.class);
    @Autowired(required=false)
    private MsproductinfoService msproductinfoService;

    @Autowired(required=false)
    private MsproductinfoRedisService msproductinfoRedisService;

    @RequestMapping(value="toApplymsproduct")
    public String toApplymsproduct(){
        logger.info("----------");
        return "msproductinfo/applymsproduct";
    }

    @RequestMapping(value="applymsproduct",method= RequestMethod.POST)
    public String applymsproduct(Msproductinfo msproductinfo){
        logger.info(msproductinfo);
        String startTime=msproductinfo.getStartTimeString();
        String endTime=msproductinfo.getEndTimeString();
        msproductinfo.setStarttime(DateUtil.str2Date(startTime));
        msproductinfo.setEndtime(DateUtil.str2Date(endTime));
        msproductinfo.setApplydate(new Date());
        msproductinfo.setAuditstate(1);
        msproductinfoService.insert(msproductinfo);
        return "redirect:listmsproduct";
    }

    @RequestMapping(value="listmsproduct")
    public String listmsproduct(HttpServletRequest req, MsProductVo msProductVo){
        List<Msproductinfo> list =  msproductinfoService.listmsproduct(msProductVo);
        req.setAttribute("list", list);
        return "msproductinfo/list";
    }


    //使用Ehcache缓存查询
    @RequestMapping(value="querymsproductByid")
    public String querymsproductByid(HttpServletRequest req,int id){
        Msproductinfo  msproductinfo =  msproductinfoRedisService.selectByPrimaryKey(id);
        if (msproductinfo==null){
            return "hello";
        }
        req.setAttribute("msproductinfo", msproductinfo);
        return "msproductinfo/view";
    }

    @RequestMapping(value="deletemsproductByid")
    public String deletemsproductByid(HttpServletRequest req,int id){
        msproductinfoService.deleteByPrimaryKey(id);
        return "redirect:listmsproduct";
    }

    @RequestMapping(value="toupdatemsproduct")
    public String toupdatemsproduct(HttpServletRequest req,int id){
        Msproductinfo  msproductinfo = msproductinfoService.selectByPrimaryKey(id);
        Date starttime = msproductinfo.getStarttime();
        Date endtime = msproductinfo.getEndtime();
        String starttimestring = "";
        String endtimestring = "";
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if(starttime != null){
            starttimestring = dateFormat.format(starttime);
        }
        if(endtime != null){
            endtimestring = dateFormat.format(endtime);
        }

        req.setAttribute("msproductinfo", msproductinfo);
        req.setAttribute("starttimestring", starttimestring);
        req.setAttribute("endtimestring", endtimestring);
        return "msproductinfo/updatemsproduct";
    }

    @RequestMapping(value="updatemsproduct",method=RequestMethod.POST)
    public String updatemsproduct(HttpServletRequest req,Msproductinfo msproductinfo){
        msproductinfoRedisService.updateProductById(msproductinfo);
        return "redirect:listmsproduct";
    }

    @RequestMapping(value="toupdatemsproductstate")
    public String toupdatemsproductstate(HttpServletRequest req,int id){
        Msproductinfo  msproductinfo = msproductinfoService.selectByPrimaryKey(id);
        Date starttime = msproductinfo.getStarttime();
        Date endtime = msproductinfo.getEndtime();
        String starttimestring = "";
        String endtimestring = "";
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if(starttime != null){
            starttimestring = dateFormat.format(starttime);
        }
        if(endtime != null){
            endtimestring = dateFormat.format(endtime);
        }

        req.setAttribute("msproductinfo", msproductinfo);
        req.setAttribute("starttimestring", starttimestring);
        req.setAttribute("endtimestring", endtimestring);
        return "msproductinfo/auditmsproduct";
    }


    @RequestMapping(value="updatemsproductstate",method=RequestMethod.POST)
    public String updatemsproductstate(HttpServletRequest req,int id,int state){
        msproductinfoService.updatemsproductstate(id,state);
        return "redirect:listmsproduct";
    } 
}
