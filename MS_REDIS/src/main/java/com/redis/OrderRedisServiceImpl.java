package com.redis;

import com.bean.Msorder;
import com.util.DateUtil;
import com.vo.ConstomOrder;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

/**
 * @classname:
 * @description:
 * @author: zhuyuchao
 * @date: 2019/1/11 19:23
 * @version: 1.0
 **/
public class OrderRedisServiceImpl implements OrderRedisService {

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private RabbitTemplate rabbitTemplate;
    public Map<String,Object> seckill(int userid, int productid, ConstomOrder msorder) {
        Map<String,Object> resultmap = new HashMap<String,Object>();
        int stockcount = msorder.getStockcount();//库存总数
        if(redisUtil.getkeylistsize(productid+"")> stockcount){
            System.out.println("秒杀失败");
            resultmap.put("success", false);
        }
        redisUtil.pushlist(productid+"", userid+"");
        System.out.println("秒杀成功");
        String key = "userid:"+userid+"==productid:"+productid;
        String value = "";

        String createtimestring = DateUtil.transferdate(new Date(), "yyyy-MM-dd HH:mm:ss");
        String merchantid = msorder.getMerchantid()+"";
        String payamount = msorder.getPayamount()+"";
        String receivingaddress = msorder.getReceivingaddress();
        String receivingname = msorder.getReceivingname();
        String receivingphone = String.valueOf(msorder.getReceivingphone());
        String stockcountnum = msorder.getStockcount()+"";
        String tradeserialnumber = createtimestring+ UUID.randomUUID();
        String paystatus = "1";
        value += paystatus+"=="+tradeserialnumber+"=="+createtimestring+"=="+merchantid+"=="+payamount+"=="+receivingaddress+"=="+receivingname+"=="+receivingphone+"=="+stockcountnum;
        redisUtil.set(key, value);
        Map<String,String> datamap = new HashMap<String,String>();
        datamap.put("createtime", createtimestring);
        datamap.put("merchantid", merchantid);
        datamap.put("payamount", payamount);
        datamap.put("receivingaddress", receivingaddress);
        datamap.put("receivingname", receivingname);
        datamap.put("receivingphone", receivingphone);
        datamap.put("stockcountnum", stockcountnum);
        datamap.put("tradeserialnumber", tradeserialnumber);
        datamap.put("paystatus", paystatus);
        datamap.put("productid", productid+"");
        datamap.put("userid", userid+"");

        rabbitTemplate.convertAndSend("ms_exchange","orderinfomation",datamap);
        resultmap.put("success", true);
        resultmap.put("datamap", datamap);
        return resultmap;
    }

    public boolean payorder(int paytype,int userid,int productid,int merchantid,String tradeserialnumber, int payamount){
        String key = "userid:"+userid+"==productid:"+productid;
        String value = (String) redisUtil.get(key);
        String[] splitvalues = value.split("==");
        splitvalues[0] = "2";
        value = "";
        for(String temp:splitvalues){
            value += temp+"==";
        }
        boolean issuccess = redisUtil.set(key, value);
        Map<String,String> datamap=new HashMap<String, String>();
        datamap.put("tradeserialnumber",tradeserialnumber);
        datamap.put("paystatus","2");
        String paytimestring=DateUtil.transferdate(new Date(),"yyyy-MM-dd HH:mm:ss");
        datamap.put("paytimestring",paytimestring);
        datamap.put("paytype",paytype+"");
        rabbitTemplate.convertAndSend("ms_exchange","payinfomation",datamap);
        return issuccess;
    }

    public List<Msorder> queryorderbyuserid(int userid){
        List<Msorder> listmsorder = new ArrayList<Msorder>();
        Set<String> keys = redisUtil.getkeys("userid:"+userid);
        for(String key :keys){
            String[] prusers = key.split("==");
            if(prusers.length <= 1){
                continue;
            }
            String productid = prusers[1].split(":")[1];
            String useridstring = prusers[0].split(":")[1];
            String value = (String) redisUtil.get(key);
            String[] valuearray = value.split("==");
            String paystatus = valuearray[0];
            String tradeserialnumber = valuearray[1];
            String createtimestring= valuearray[2];
            String merchantid = valuearray[3];
            String payamount = valuearray[4];
            String receivingaddress= valuearray[5];
            String receivingname= valuearray[6];
            String receivingphone= valuearray[7];
            String stockcountnum= valuearray[8];
            Msorder msorder = new Msorder();
            msorder.setCreatetime(DateUtil.str2Date(createtimestring));
            msorder.setPayamount(Integer.valueOf(payamount));
            msorder.setMerchantid(Integer.valueOf(merchantid));
            msorder.setReceivingaddress(receivingaddress);
            msorder.setReceivingname(receivingname);
            msorder.setProductid(Integer.valueOf(productid));
            msorder.setReceivingphone(Integer.valueOf(receivingphone));
            msorder.setTradeserialnumber(tradeserialnumber);
            msorder.setUserid(userid);
            msorder.setNum(1);
            msorder.setPaystatus(Integer.valueOf(paystatus));
            listmsorder.add(msorder);
        }
        return listmsorder;
    }
}
