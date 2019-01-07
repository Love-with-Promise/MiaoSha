package com.impl;

import com.bean.Msmerchant;
import com.common.AbstractService;
import com.dao.MsmerchantMapper;
import com.service.MsmerchantService;
import com.vo.MsmerchantVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @classname:
 * @description:
 * @author: zhuyuchao
 * @date: 2018/12/5 18:56
 * @version: 1.0
 **/
@Service
public class MsmerchantServiceImpl extends AbstractService<Msmerchant,Integer> implements MsmerchantService{
    @Autowired
    MsmerchantMapper msmerchantMapper;

    @Override
    public List<Msmerchant> queryMsmerchantbyvo(MsmerchantVo msmerchantVo) {
        return msmerchantMapper.queryMsmerchantbyvo(msmerchantVo);
    }

    @Override
    public Msmerchant queryMsmerchantByaccount(String account) {
        return msmerchantMapper.queryMsmerchantByaccount(account);
    }
}
