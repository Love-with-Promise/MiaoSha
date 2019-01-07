package com.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.bean.Msuser;
import com.common.BaseController;
import com.service.MsuserService;
import com.vo.MsuserVo;
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
 * @date: 2018/12/5 19:05
 * @version: 1.0
 **/
@Controller
@RequestMapping("msuser")
public class MsuserController extends BaseController {
    @Autowired(required=false)
    MsuserService msuserService;


    @RequestMapping("toadd")
    public String toadd(){
        System.out.println("--------------");
        return "user/add";
    }

    @RequestMapping(value = "add",method= RequestMethod.POST)
    public String add(Msuser msuser){
        msuserService.insert(msuser);
        System.out.println(msuser);
        return "redirect:querybyvo";
    }

    @RequestMapping("toupdate")
    public String toupdate(HttpServletRequest request, int id){
        Msuser user = msuserService.selectByPrimaryKey(id);
        request.setAttribute("msuser",user);
        return "user/update";
    }

    @RequestMapping(value="update",method=RequestMethod.POST)
    public String update(HttpServletRequest request,Msuser msuser){
        msuserService.updateByPrimaryKey(msuser);
        System.out.println(msuser);
        return "redirect:querybyvo";
    }

    @RequestMapping("del")
    public String del(HttpServletRequest request,int id){
        msuserService.deleteByPrimaryKey(id);
        return "redirect:querybyvo";
    }

    @RequestMapping("querybyid")
    public String querybyid(HttpServletRequest request,int id){
        Msuser msuser = msuserService.selectByPrimaryKey(id);
        request.setAttribute("msuser", msuser);
        return "user/view";
    }

    @RequestMapping("querybyvo")
    public String querybyvo(HttpServletRequest request,MsuserVo msuserVo){
        List<Msuser> list = msuserService.queryMsuserbyvo(msuserVo);
        request.setAttribute("msuserlist", list);
        return "user/list";
    }

}
