package com.service;

import com.bean.Msproductinfo;
import com.common.BaseService;
import com.vo.MsProductVo;

import java.util.List;

/**
 * @classname:
 * @description:
 * @author: zhuyuchao
 * @date: 2018/12/5 18:56
 * @version: 1.0
 **/
public interface MsproductinfoService extends BaseService<Msproductinfo,Integer> {
    List<Msproductinfo> listmsproduct(MsProductVo msProductVo);

    void updatemsproductstate(int id, int state);
}
