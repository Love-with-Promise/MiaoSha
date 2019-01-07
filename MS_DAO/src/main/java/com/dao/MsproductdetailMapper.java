package com.dao;

import com.bean.Msproductdetail;
import com.common.BaseMapper;

public interface MsproductdetailMapper extends BaseMapper<Msproductdetail,Integer> {
    int deleteByPrimaryKey(Integer id);

    int insert(Msproductdetail record);

    int insertSelective(Msproductdetail record);

    Msproductdetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Msproductdetail record);

    int updateByPrimaryKey(Msproductdetail record);

    Msproductdetail queryMsproductdetailByid(int productid);

    void updateMsproductdetail(Msproductdetail msproductdetail);
}