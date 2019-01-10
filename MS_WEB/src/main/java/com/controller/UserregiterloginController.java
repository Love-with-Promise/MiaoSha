package com.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.bean.Msuser;
import com.service.MsuserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @classname:
 * @description:
 * @author: zhuyuchao
 * @date: 2018/12/6 19:03
 * @version: 1.0
 **/
@Controller
@RequestMapping("userregiterloginAction")
public class UserregiterloginController {
    final static Logger logger=Logger.getLogger(UserregiterloginController.class);
    @Autowired(required=false)
    private MsuserService msuserService;
    @RequestMapping(value = "toregiter")
    public String toregiter(){
        return "user/toregiter";
    }

    @RequestMapping(value = "regiter",method= RequestMethod.POST)
    public String regiter(HttpServletRequest req, Msuser msuser){
        msuserService.insert(msuser);
        HttpSession sess = req.getSession();
        sess.setAttribute("msuser", msuser);
        System.out.println(msuser);
        return "homepage/homepage";
    }

    @RequestMapping(value = "tologin")
    public String tologin(HttpServletRequest req,Msuser msuser){

        return "user/tologin";
    }

    @RequestMapping(value = "login",method=RequestMethod.POST)
    public String login(HttpServletRequest req,Msuser msuser){
        String returnurl = "homepage/error";
        String account = msuser.getUseraccount();
        String password = msuser.getUserpassword();
        Msuser msuserresult = msuserService.queryMsuserByuseraccount(account);
        if(msuserresult == null ){
            System.out.println("无此用户");
            req.setAttribute("errorinfo", "无此用户");
        }else if(!msuserresult.getUserpassword().equals(password)){
            System.out.println("密码错误");
            req.setAttribute("errorinfo", "密码错误");
        }else{
            HttpSession sess = req.getSession();
            sess.setAttribute("msuser", msuserresult);
            returnurl = "homepage/homepage";
        }
        return returnurl;
    }

    @RequestMapping(value = "exit")
    public String exit(HttpServletRequest req){
        HttpSession sess = req.getSession();
        sess.removeAttribute("msuser");
        return "homepage/homepage";
    }

}
