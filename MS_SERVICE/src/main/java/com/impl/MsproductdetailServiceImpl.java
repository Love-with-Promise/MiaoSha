package com.impl;

import com.bean.Msproductdetail;
import com.common.AbstractService;
import com.dao.MsproductdetailMapper;
import com.service.MsproductdetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @classname:
 * @description:
 * @author: zhuyuchao
 * @date: 2018/12/5 18:57
 * @version: 1.0
 **/
@Service
public class MsproductdetailServiceImpl extends AbstractService<Msproductdetail,Integer> implements MsproductdetailService{
    @Autowired
    private MsproductdetailMapper msproductdetailMapper;

    @Override
    public Msproductdetail queryMsproductdetailByid(int productid) {
        return msproductdetailMapper.queryMsproductdetailByid(productid);
    }

    @Override
    public void updateMsproductdetail(Msproductdetail msproductdetail) {
        msproductdetailMapper.updateMsproductdetail(msproductdetail);
    }
}
