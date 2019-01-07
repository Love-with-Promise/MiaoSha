package com.controller;

import com.bean.Msmerchant;
import com.common.BaseController;
import com.service.MsmerchantService;
import com.vo.MsmerchantVo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @classname:
 * @description:
 * @author: zhuyuchao
 * @date: 2018/12/5 19:03
 * @version: 1.0
 **/
@Controller
@RequestMapping(value = "msmerchant")
public class MsmerchantController extends BaseController {
    final  static Logger logger=Logger.getLogger(MsmerchantController.class);

    @Autowired
    private MsmerchantService msmerchantService;


    @RequestMapping("toAdd")
    public String toAdd() {
       logger.info("toADD");
        return "msmerchant/add";
    }

    @RequestMapping(value = "add",method=RequestMethod.POST)
    public String add(Msmerchant msmerchant){
        msmerchantService.insert(msmerchant);
        System.out.println(msmerchant);
        return "redirect:querybyvo";
    }

    @RequestMapping("toupdate")
    public String toupdate(HttpServletRequest request, int id){
        Msmerchant msmerchant = msmerchantService.selectByPrimaryKey(id);
        request.setAttribute("msmerchant", msmerchant);
        return "msmerchant/update";
    }

    @RequestMapping(value="update",method=RequestMethod.POST)
    public String update(HttpServletRequest request,Msmerchant msmerchant){
        msmerchantService.updateByPrimaryKey(msmerchant);
        return "redirect:querybyvo";
    }

    @RequestMapping("del")
    public String del(HttpServletRequest request,int id){
        msmerchantService.deleteByPrimaryKey(id);
        return "redirect:querybyvo";
    }

    @RequestMapping("querybyid")
    public String querybyid(HttpServletRequest request,int id){
        Msmerchant msmerchant = msmerchantService.selectByPrimaryKey(id);
        request.setAttribute("msmerchant", msmerchant);
        return "msmerchant/view";
    }

    @RequestMapping("querybyvo")
    public String querybyvo(HttpServletRequest request,MsmerchantVo msmerchantVo){
        List<Msmerchant> list = msmerchantService.queryMsmerchantbyvo(msmerchantVo);
        request.setAttribute("msmerchantlist", list);
        return "msmerchant/list";
    }
}
