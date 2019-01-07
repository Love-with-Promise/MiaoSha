package com.vo;

import java.io.Serializable;

/**
 * @classname:
 * @description:
 * @author: zhuyuchao
 * @date: 2018/12/8 10:39
 * @version: 1.0
 **/
public class MsorderVo implements Serializable{
    private ConstomOrder constomOrder;

    public ConstomOrder getConstomOrder() {
        return constomOrder;
    }

    public void setConstomOrder(ConstomOrder constomOrder) {
        this.constomOrder = constomOrder;
    }
}
