package com.service;

import com.bean.Msorder;
import com.common.BaseService;

import java.util.Date;
import java.util.List;

/**
 * @classname:
 * @description:
 * @author: zhuyuchao
 * @date: 2018/12/5 18:55
 * @version: 1.0
 **/
public interface MsorderService extends BaseService<Msorder,Integer> {

    List<Msorder> selectByUserId(int userid);

    void updateorderpaystatusbyid(int payStatus, int id, int payType);

    void updateorderpaystatusbynumber(int payStatus, String tradeserialnumber, int payType, Date paytime);
}
