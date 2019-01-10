package com.redis;

import com.bean.Msproductdetail;

/**
 * @classname:
 * @description:
 * @author: zhuyuchao
 * @date: 2018/12/5 18:55
 * @version: 1.0
 **/
public interface MsproductdetailRedisService {
    Msproductdetail queryMsproductdetailByid(int productid);
}
