package com.service;

import com.bean.Msmerchant;
import com.common.BaseService;
import com.vo.MsmerchantVo;

import java.util.List;

/**
 * @classname:
 * @description:
 * @author: zhuyuchao
 * @date: 2018/12/5 18:54
 * @version: 1.0
 **/
public interface MsmerchantService extends BaseService<Msmerchant,Integer> {

    List<Msmerchant> queryMsmerchantbyvo(MsmerchantVo msmerchantVo);

    Msmerchant queryMsmerchantByaccount(String account);
}
