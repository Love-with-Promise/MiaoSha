package com.impl;

import com.service.PayOrderService;
import org.springframework.stereotype.Service;

/**
 * @classname:
 * @description:
 * @author: zhuyuchao
 * @date: 2018/12/6 22:02
 * @version: 1.0
 **/
@Service(value = "yinLianServiceImpl")
public class YinLianServiceImpl implements PayOrderService {

    @Override
    public int payToOrder(String tradeserialnumber, int payamount) {
        return 1;
    }

    @Override
    public int refundwithorder(String tradeserialnumber, int payamount) {
        return 1;
    }
}
