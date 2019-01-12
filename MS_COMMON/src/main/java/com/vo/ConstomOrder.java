package com.vo;

import com.bean.Msorder;

/**
 * @classname:
 * @description:
 * @author: zhuyuchao
 * @date: 2018/12/8 10:38
 * @version: 1.0
 **/
public class ConstomOrder extends Msorder {
    private Integer stockcount;

    public Integer getStockcount() {
        return stockcount;
    }

    public void setStockcount(Integer stockcount) {
        this.stockcount = stockcount;
    }
}
