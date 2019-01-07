package com.service;

import com.bean.Msuser;
import com.common.BaseService;
import com.vo.MsuserVo;


import java.util.List;

/**
 * @classname:
 * @description:
 * @author: zhuyuchao
 * @date: 2018/12/5 18:56
 * @version: 1.0
 **/
public interface MsuserService extends BaseService<Msuser,Integer> {
    List<Msuser> queryMsuserbyvo(MsuserVo msuserVo);

    Msuser queryMsuserByuseraccount(String account);
}
