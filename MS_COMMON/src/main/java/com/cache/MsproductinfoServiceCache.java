package com.cache;

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
public interface MsproductinfoServiceCache  {
     Msproductinfo selectByPrimaryKey(int id);

     Msproductinfo updateproductbyid(Msproductinfo msproductinfo);
}
