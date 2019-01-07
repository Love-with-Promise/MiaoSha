package com.service;

/**
 * @classname:
 * @description:
 * @author: zhuyuchao
 * @date: 2018/12/6 21:59
 * @version: 1.0
 **/
public interface PayOrderService {
    int payToOrder(String tradeserialnumber,int payamount);

    int refundwithorder(String tradeserialnumber,int payamount);
}
