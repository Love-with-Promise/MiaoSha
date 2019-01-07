package com.dao;

import com.bean.Msuser;
import com.common.BaseMapper;
import com.vo.MsuserVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MsuserMapper extends BaseMapper<Msuser,Integer> {
    int deleteByPrimaryKey(Integer id);

    int insert(Msuser record);

    int insertSelective(Msuser record);

    Msuser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Msuser record);

    int updateByPrimaryKey(Msuser record);

    List<Msuser> queryMsuserbyvo(MsuserVo msuserVo);

    Msuser queryMsuserByuseraccount(@Param("account") String account);
}