package com.vo;


import com.bean.Msproductinfo;

import java.util.Date;


public class ConstomProduct  extends Msproductinfo {
	private int startmiaoshaprice;//秒杀价格查询范围开始
	private int endmiaoshaprice;//秒杀价格查询范围结束

	private int startoriginalprice;//商品原价查询范围开始
	private int endoriginalprice;//商品原价查询范围结束

	private Date startapplydate;//申请时间查询范围开始时间
	private Date endapplydate;//申请时间查询范围结束时间

	private Date startauditdate;//审核时间查询范围开始时间
	private Date endauditdate;//审核时间查询范围结束时间

	private Date startstarttime;//秒杀开始时间查询范围开始时间
	private Date endstarttime;//秒杀开始时间查询范围结束时间

	private String startendtime;//秒杀结束时间查询范围开始时间
	private String endendtime;//秒杀结束时间查询范围结束时间

	private int startproductcount;//秒杀商品数开始范围
	private int endproductcount;//秒杀商品数结束范围

	private int startstockcount;//库存开始范围
	private int endstockcount;//库存结束范围

	public int getStartmiaoshaprice() {
		return startmiaoshaprice;
	}
	public void setStartmiaoshaprice(int startmiaoshaprice) {
		this.startmiaoshaprice = startmiaoshaprice;
	}
	public int getEndmiaoshaprice() {
		return endmiaoshaprice;
	}
	public void setEndmiaoshaprice(int endmiaoshaprice) {
		this.endmiaoshaprice = endmiaoshaprice;
	}
	public int getStartoriginalprice() {
		return startoriginalprice;
	}
	public void setStartoriginalprice(int startoriginalprice) {
		this.startoriginalprice = startoriginalprice;
	}
	public int getEndoriginalprice() {
		return endoriginalprice;
	}
	public void setEndoriginalprice(int endoriginalprice) {
		this.endoriginalprice = endoriginalprice;
	}
	public Date getStartapplydate() {
		return startapplydate;
	}
	public void setStartapplydate(Date startapplydate) {
		this.startapplydate = startapplydate;
	}
	public Date getEndapplydate() {
		return endapplydate;
	}
	public void setEndapplydate(Date endapplydate) {
		this.endapplydate = endapplydate;
	}
	public Date getStartauditdate() {
		return startauditdate;
	}
	public void setStartauditdate(Date startauditdate) {
		this.startauditdate = startauditdate;
	}
	public Date getEndauditdate() {
		return endauditdate;
	}
	public void setEndauditdate(Date endauditdate) {
		this.endauditdate = endauditdate;
	}
	public Date getStartstarttime() {
		return startstarttime;
	}
	public void setStartstarttime(Date startstarttime) {
		this.startstarttime = startstarttime;
	}
	public Date getEndstarttime() {
		return endstarttime;
	}
	public void setEndstarttime(Date endstarttime) {
		this.endstarttime = endstarttime;
	}
	public String getStartendtime() {
		return startendtime;
	}
	public void setStartendtime(String startendtime) {
		this.startendtime = startendtime;
	}
	public String getEndendtime() {
		return endendtime;
	}
	public void setEndendtime(String endendtime) {
		this.endendtime = endendtime;
	}
	public int getStartproductcount() {
		return startproductcount;
	}
	public void setStartproductcount(int startproductcount) {
		this.startproductcount = startproductcount;
	}
	public int getEndproductcount() {
		return endproductcount;
	}
	public void setEndproductcount(int endproductcount) {
		this.endproductcount = endproductcount;
	}
	public int getStartstockcount() {
		return startstockcount;
	}
	public void setStartstockcount(int startstockcount) {
		this.startstockcount = startstockcount;
	}
	public int getEndstockcount() {
		return endstockcount;
	}
	public void setEndstockcount(int endstockcount) {
		this.endstockcount = endstockcount;
	}


}
