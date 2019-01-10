package com.redis;

import com.bean.Msproductinfo;

/**
 * @classname:
 * @description:
 * @author: zhuyuchao
 * @date: 2018/12/5 18:56
 * @version: 1.0
 **/
public interface MsproductinfoRedisService {
     Msproductinfo selectByPrimaryKey(int id);
}
