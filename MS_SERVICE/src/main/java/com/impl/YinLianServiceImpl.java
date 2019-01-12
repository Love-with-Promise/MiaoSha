package com.impl;

import com.pay.YinLianPay;
import com.service.PayOrderService;
import org.springframework.stereotype.Service;

/**
 * @classname:
 * @description:
 * @author: zhuyuchao
 * @date: 2018/12/6 22:02
 * @version: 1.0
 **/
@Service
public class YinLianServiceImpl implements YinLianPay {

    @Override
    public int payToOrder(String tradeserialnumber, int payamount) {
        return 1;
    }

    @Override
    public int refundwithorder(String tradeserialnumber, int payamount) {
        return 1;
    }
}
