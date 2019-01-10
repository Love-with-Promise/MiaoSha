package com.service;

import com.bean.Msproductdetail;
import com.cache.MsproductdetailServiceCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;

/**
 * @classname:
 * @description:
 * @author: zhuyuchao
 * @date: 2019/1/10 14:28
 * @version: 1.0
 **/
public class MsproductdetailServiceCacheImpl implements MsproductdetailServiceCache {

    @Autowired
    private MsproductdetailService msproductdetailService;
    @Cacheable(value = "MS_CACHE",key = "'productdetail:'+#productid")
    public Msproductdetail queryMsproductdetailByid(int productid) {
        System.out.println("come into queryMsproductdetailByid");
        return msproductdetailService.queryMsproductdetailByid(productid);
    }
}
