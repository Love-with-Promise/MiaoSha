package com.impl;

import com.bean.Msproductinfo;
import com.common.AbstractService;
import com.dao.MsproductinfoMapper;
import com.service.MsproductinfoService;
import com.vo.ConstomProduct;
import com.vo.MsProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @classname:
 * @description:
 * @author: zhuyuchao
 * @date: 2018/12/5 18:57
 * @version: 1.0
 **/
@Service
public class MsproductinfoServiceImpl extends AbstractService<Msproductinfo,Integer> implements MsproductinfoService {
    @Autowired
    MsproductinfoMapper msproductinfoMapper;

    @Override
    public List<Msproductinfo> listmsproduct(MsProductVo msProductVo) {
        return msproductinfoMapper.listmsproduct(msProductVo);
    }


    @Override
    public void updatemsproductstate(int id, int state) {
        MsProductVo msProductVo = new MsProductVo();
        ConstomProduct constomProduct = new ConstomProduct();
        constomProduct.setId(id);
        constomProduct.setAuditstate(state);
        msProductVo.setConstomProduct(constomProduct);
        msproductinfoMapper.updatemsproductstate(msProductVo);
    }
}
