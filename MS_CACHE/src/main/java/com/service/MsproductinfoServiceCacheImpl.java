package com.service;

import com.bean.Msproductdetail;
import com.bean.Msproductinfo;
import com.cache.MsproductdetailServiceCache;
import com.cache.MsproductinfoServiceCache;
import com.vo.MsProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * @classname:
 * @description:
 * @author: zhuyuchao
 * @date: 2019/1/10 14:28
 * @version: 1.0
 **/
public class MsproductinfoServiceCacheImpl implements MsproductinfoServiceCache {

    @Autowired
    private MsproductinfoService msproductinfoService;

    @Cacheable(value = "MS_CACHE" ,key = "'product:'+#id")
    public Msproductinfo selectByPrimaryKey(int id) {
        System.out.println("come into selectByPrimaryKey");
        return msproductinfoService.selectByPrimaryKey(id);
    }

    /**
     * 根据秒杀商品ID更新商品信息
     * @param msproductinfo
     */
    @CachePut(value = "MS_CACHE",key = "'product:'+#id")
    public Msproductinfo updateproductbyid(Msproductinfo msproductinfo){
        System.out.println("come into updateproductbyid");
        msproductinfoService.updateByPrimaryKey(msproductinfo);
        return msproductinfoService.selectByPrimaryKey(msproductinfo.getId());
    }
}
