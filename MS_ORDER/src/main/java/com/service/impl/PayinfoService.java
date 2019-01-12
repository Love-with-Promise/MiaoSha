package com.service.impl;

import com.service.MsorderService;
import com.util.DateUtil;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Map;

/**
 * @classname:
 * @description:
 * @author: zhuyuchao
 * @date: 2019/1/11 17:15
 * @version: 1.0
 **/
public class PayinfoService implements MessageListener {
    @Autowired
    private MsorderService msorderService;
    public void onMessage(Message message) {
        try {
            byte[] bytes=message.getBody();
            ByteArrayInputStream in=new ByteArrayInputStream(bytes);
            ObjectInputStream obj=new ObjectInputStream(in);
            Map<String,String> datamap= (Map<String, String>) obj.readObject();
            String tradeserialnumber = datamap.get("tradeserialnumber");
            String paystatus = datamap.get("paystatus");
            String paytimestring = datamap.get("paytimestring");
            String paytype = datamap.get("paytype");
            msorderService.updateorderpaystatusbynumber(Integer.valueOf(paystatus),tradeserialnumber,Integer.valueOf(paytype), DateUtil.str2Date(paytimestring));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("消费者消息="+message.toString());
    }
}
