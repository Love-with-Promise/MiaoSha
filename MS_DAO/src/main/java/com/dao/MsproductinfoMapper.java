package com.dao;

import com.bean.Msproductinfo;
import com.common.BaseMapper;
import com.vo.MsProductVo;

import java.util.List;

public interface MsproductinfoMapper extends BaseMapper<Msproductinfo,Integer> {
    int deleteByPrimaryKey(Integer id);

    int insert(Msproductinfo record);

    int insertSelective(Msproductinfo record);

    Msproductinfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Msproductinfo record);

    int updateByPrimaryKey(Msproductinfo record);

    List<Msproductinfo> listmsproduct(MsProductVo msProductVo);

    void updatemsproductstate(MsProductVo msProductVo);
}