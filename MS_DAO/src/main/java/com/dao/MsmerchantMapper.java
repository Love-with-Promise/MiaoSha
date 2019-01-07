package com.dao;

import com.bean.Msmerchant;
import com.common.BaseMapper;
import com.vo.MsmerchantVo;

import java.util.List;

public interface MsmerchantMapper extends BaseMapper<Msmerchant,Integer> {
    int deleteByPrimaryKey(Integer id);

    int insert(Msmerchant record);

    int insertSelective(Msmerchant record);

    Msmerchant selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Msmerchant record);

    int updateByPrimaryKey(Msmerchant record);

    List<Msmerchant> queryMsmerchantbyvo(MsmerchantVo msmerchantVo);

    Msmerchant queryMsmerchantByaccount(String account);
}