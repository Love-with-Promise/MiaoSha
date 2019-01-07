package com.impl;

import com.bean.Msuser;
import com.common.AbstractService;
import com.dao.MsuserMapper;
import com.service.MsuserService;
import com.vo.MsuserVo;
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
public class MsuserServiceImpl extends AbstractService<Msuser,Integer> implements MsuserService {
    @Autowired
    MsuserMapper msuserMapper;

    @Override
    public List<Msuser> queryMsuserbyvo(MsuserVo msuserVo) {
        return msuserMapper.queryMsuserbyvo(msuserVo);
    }


    @Override
    public Msuser queryMsuserByuseraccount(String account) {
        return msuserMapper.queryMsuserByuseraccount(account);
    }
}
