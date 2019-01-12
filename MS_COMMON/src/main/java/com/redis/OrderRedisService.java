package com.redis;

import com.bean.Msorder;
import com.vo.ConstomOrder;

import java.util.List;
import java.util.Map;

/**
 * @classname:
 * @description:
 * @author: zhuyuchao
 * @date: 2019/1/11 18:58
 * @version: 1.0
 **/
public interface OrderRedisService {
    public Map<String,Object> seckill(int userid, int productid, ConstomOrder msorder);

    public boolean payorder(int paytype,int userid,int productid,int merchantid,String tradeserialnumber, int payamount);

    List<Msorder> queryorderbyuserid(int userid);
}
