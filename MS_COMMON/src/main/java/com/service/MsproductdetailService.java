package com.service;

import com.bean.Msproductdetail;
import com.common.BaseService;

/**
 * @classname:
 * @description:
 * @author: zhuyuchao
 * @date: 2018/12/5 18:55
 * @version: 1.0
 **/
public interface MsproductdetailService extends BaseService<Msproductdetail,Integer> {
    Msproductdetail queryMsproductdetailByid(int productid);

    void updateMsproductdetail(Msproductdetail msproductdetail);
}
