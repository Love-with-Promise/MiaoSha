package com.service.impl;

import com.bean.Msorder;
import com.service.MsorderService;
import com.util.DateUtil;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.util.Map;

/**
 * @classname:
 * @description:
 * @author: zhuyuchao
 * @date: 2019/1/11 17:15
 * @version: 1.0
 **/
public class OrderinfoService implements MessageListener {
    @Autowired
    private MsorderService msorderService;
    public void onMessage(Message message) {
        try {
            byte[] messagebyte=message.getBody();
            //反序列化
            ByteArrayInputStream in=new ByteArrayInputStream(messagebyte);
            ObjectInputStream obj=new ObjectInputStream(in);
            Map<String,String> datamap= (Map<String, String>) obj.readObject();
            String createtime=datamap.get("createtime");
            String merchantid=datamap.get("merchantid");
            String payamount=datamap.get("payamount");
            String receivingaddress=datamap.get("receivingaddress");
            String receivingname=datamap.get("receivingname");
            String receivingphone = datamap.get("receivingphone");
            String stockcountnum=datamap.get("stockcountnum");
            String tradeserialnumber=datamap.get("tradeserialnumber");
            String paystatus=datamap.get("paystatus");
            String productid=datamap.get("productid");
            String userid=datamap.get("userid");
            Msorder msorder=new Msorder();
            msorder.setUserid(Integer.valueOf(userid));
            msorder.setProductid(Integer.valueOf(productid));
            msorder.setCreatetime(DateUtil.str2Date(createtime));
            msorder.setTradeserialnumber(tradeserialnumber);
            msorder.setMerchantid(Integer.valueOf(merchantid));
            msorder.setNum(1);
            msorder.setPayamount(Integer.valueOf(payamount));
            msorder.setPaystatus(Integer.valueOf(paystatus));
            msorder.setReceivingaddress(receivingaddress);
            msorder.setReceivingname(receivingname);
            msorder.setReceivingphone(Integer.valueOf(receivingphone));
            msorderService.insert(msorder);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("消息消费者 = " + message.toString());
    }
}
