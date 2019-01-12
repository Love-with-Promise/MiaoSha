package com.dao;

import com.bean.Msorder;
import com.common.BaseMapper;
import com.vo.MsorderVo;

import java.util.List;

public interface MsorderMapper extends BaseMapper<Msorder,Integer> {
    int deleteByPrimaryKey(Integer id);

    int insert(Msorder record);

    int insertSelective(Msorder record);

    Msorder selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Msorder record);

    int updateByPrimaryKey(Msorder record);

    List<Msorder> selectByUserId(int userid);

    void updateorderpaystatusbyid(MsorderVo msorderVo);

    void updateorderpaystatusbynumber(MsorderVo msorderVo);

    void updateOrderpayStatusBytradeSerialnumber(MsorderVo msorderVo);

    List<Msorder> selectListOrder();

    void updateFlagById(Msorder msorder);
}