package com.redis;

import com.bean.Msproductdetail;
import com.cache.MsproductdetailServiceCache;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @classname:
 * @description:
 * @author: zhuyuchao
 * @date: 2019/1/10 20:55
 * @version: 1.0
 **/
public class MsproductdetailRedisServiceImpl implements MsproductdetailRedisService {
    @Autowired
    private MsproductdetailServiceCache msproductdetailServiceCache;

    @Autowired
    private RedisUtil redisUtil;
    public Msproductdetail queryMsproductdetailByid(int productid) {
        Msproductdetail msproductdetail=null;
        Object result = redisUtil.get("detail:"+productid);
        if (result==null){
            msproductdetail= msproductdetailServiceCache.queryMsproductdetailByid(productid);
            redisUtil.set("detail:"+productid,msproductdetail);
        }else {
            System.out.println("come into redis--queryMsproductdetailByid");
            msproductdetail= (Msproductdetail) result;
        }
        return msproductdetail;
    }
}
