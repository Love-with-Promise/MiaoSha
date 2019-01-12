package com.impl;

import com.bean.Msorder;
import com.common.AbstractService;
import com.dao.MsorderMapper;
import com.service.MsorderService;
import com.vo.ConstomOrder;
import com.vo.MsorderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @classname:
 * @description:
 * @author: zhuyuchao
 * @date: 2018/12/5 18:56
 * @version: 1.0
 **/
@Service
public class MsorderServiceImpl extends AbstractService<Msorder,Integer> implements MsorderService {
    @Autowired
    private MsorderMapper msorderMapper;

    public List<Msorder> selectByUserId(int userid) {
        return msorderMapper.selectByUserId(userid);
    }

    @Override
    public void updateorderpaystatusbyid(int payStatus, int id, int payType) {
        MsorderVo msorderVo=new MsorderVo();
        ConstomOrder constomOrder=new ConstomOrder();
        constomOrder.setPaystatus(payStatus);
        constomOrder.setId(id);
        constomOrder.setPaytype(payType);
        msorderVo.setConstomOrder(constomOrder);
        msorderMapper.updateorderpaystatusbyid(msorderVo);
    }

    @Override
    public void updateorderpaystatusbynumber(int payStatus, String tradeserialnumber, int payType, Date paytime) {
        MsorderVo msorderVo=new MsorderVo();
        ConstomOrder constomOrder=new ConstomOrder();
        constomOrder.setPaystatus(payStatus);
        constomOrder.setTradeserialnumber(tradeserialnumber);
        constomOrder.setPaytype(payType);
        constomOrder.setPaytime(paytime);
        msorderVo.setConstomOrder(constomOrder);
        msorderMapper.updateorderpaystatusbynumber(msorderVo);
    }


    public void updateOrderpayStatusByTradeserialnumber(int payStatus, String tradeserialnumber){
        MsorderVo msorderVo=new MsorderVo();
        ConstomOrder constomOrder=new ConstomOrder();
        constomOrder.setPaytype(payStatus);
        constomOrder.setTradeserialnumber(tradeserialnumber);
        msorderVo.setConstomOrder(constomOrder);
        msorderMapper.updateOrderpayStatusBytradeSerialnumber(msorderVo);
    }

    @Override
    public List<Msorder> listOrder() {
        return msorderMapper.selectListOrder();
    }

    @Override
    public void updateFlagById(int orderflag, Integer id) {
        Msorder msorder=new Msorder();
        msorder.setId(id);
        msorder.setOrderflag(orderflag);
        msorderMapper.updateFlagById(msorder);
    }
}
