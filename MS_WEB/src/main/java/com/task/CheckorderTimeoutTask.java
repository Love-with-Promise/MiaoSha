package com.task;

import com.bean.Msorder;
import com.service.MsorderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.List;

/**
 * @classname:
 * @description:
 * @author: zhuyuchao
 * @date: 2019/1/12 18:25
 * @version: 1.0
 **/
@Controller
public class CheckorderTimeoutTask {
    @Autowired
    private MsorderService msorderService;

    public void ChecktimeOutOrder(long minutes){
        List<Msorder> msorderList=msorderService.listOrder();
        for (Msorder msorder:msorderList){
            Date createtime=msorder.getCreatetime();
            Date paytime=msorder.getPaytime();
            if (paytime!=null){
                continue;
            }
            Long timedistance=System.currentTimeMillis()-createtime.getTime();
            long minute=timedistance/60*1000;
            if (minute>minutes){
                //订单取消
                msorderService.updateFlagById(1,msorder.getId());
            }
        }
        System.out.println("---------ChecktimeOutOrder---------");
    }
}
