package com.redis;

import com.bean.Msproductinfo;
import com.cache.MsproductinfoServiceCache;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @classname:
 * @description:
 * @author: zhuyuchao
 * @date: 2019/1/10 20:55
 * @version: 1.0
 **/
public class MsproductinfoRedisServiceImpl implements MsproductinfoRedisService {
    @Autowired
    private MsproductinfoServiceCache msproductinfoServiceCache;

    @Autowired
    private RedisUtil redisUtil;
    Msproductinfo msproductinfo=null;
    public Msproductinfo selectByPrimaryKey(int id) {
        Object result=redisUtil.get("product:"+id);
        if (result==null){
            msproductinfo=msproductinfoServiceCache.selectByPrimaryKey(id);
            redisUtil.set("product:"+id,msproductinfo);
        }else {
            System.out.println("come into redis  -- selectByPrimaryKey ");
            msproductinfo= (Msproductinfo) result;
        }
        return msproductinfo;
    }

    public void updateProductById(Msproductinfo msproductinfo){
        Msproductinfo msproductinfo1=msproductinfoServiceCache.updateproductbyid(msproductinfo);
        int id=msproductinfo1.getId();
        msproductinfo=msproductinfoServiceCache.selectByPrimaryKey(id);
        redisUtil.set("product:"+id,msproductinfo);
    }
}
