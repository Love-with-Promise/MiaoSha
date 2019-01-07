package com.bean;

import java.io.Serializable;
import java.util.Date;

public class Msorder implements Serializable {
    private Integer id;

    private Integer productid;

    private Integer payamount;

    private Integer merchantid;

    private Integer userid;

    private Date createtime;

    private Date paytime;

    private Integer paystatus;

    private String receivingaddress;

    private Integer receivingphone;

    private String receivingname;

    private String tradeserialnumber;

    private Integer num;

    private Integer paytype;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    public Integer getPayamount() {
        return payamount;
    }

    public void setPayamount(Integer payamount) {
        this.payamount = payamount;
    }

    public Integer getMerchantid() {
        return merchantid;
    }

    public void setMerchantid(Integer merchantid) {
        this.merchantid = merchantid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getPaytime() {
        return paytime;
    }

    public void setPaytime(Date paytime) {
        this.paytime = paytime;
    }

    public Integer getPaystatus() {
        return paystatus;
    }

    public void setPaystatus(Integer paystatus) {
        this.paystatus = paystatus;
    }

    public String getReceivingaddress() {
        return receivingaddress;
    }

    public void setReceivingaddress(String receivingaddress) {
        this.receivingaddress = receivingaddress == null ? null : receivingaddress.trim();
    }

    public Integer getReceivingphone() {
        return receivingphone;
    }

    public void setReceivingphone(Integer receivingphone) {
        this.receivingphone = receivingphone;
    }

    public String getReceivingname() {
        return receivingname;
    }

    public void setReceivingname(String receivingname) {
        this.receivingname = receivingname == null ? null : receivingname.trim();
    }

    public String getTradeserialnumber() {
        return tradeserialnumber;
    }

    public void setTradeserialnumber(String tradeserialnumber) {
        this.tradeserialnumber = tradeserialnumber == null ? null : tradeserialnumber.trim();
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getPaytype() {
        return paytype;
    }

    public void setPaytype(Integer paytype) {
        this.paytype = paytype;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Msorder other = (Msorder) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getProductid() == null ? other.getProductid() == null : this.getProductid().equals(other.getProductid()))
            && (this.getPayamount() == null ? other.getPayamount() == null : this.getPayamount().equals(other.getPayamount()))
            && (this.getMerchantid() == null ? other.getMerchantid() == null : this.getMerchantid().equals(other.getMerchantid()))
            && (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getPaytime() == null ? other.getPaytime() == null : this.getPaytime().equals(other.getPaytime()))
            && (this.getPaystatus() == null ? other.getPaystatus() == null : this.getPaystatus().equals(other.getPaystatus()))
            && (this.getReceivingaddress() == null ? other.getReceivingaddress() == null : this.getReceivingaddress().equals(other.getReceivingaddress()))
            && (this.getReceivingphone() == null ? other.getReceivingphone() == null : this.getReceivingphone().equals(other.getReceivingphone()))
            && (this.getReceivingname() == null ? other.getReceivingname() == null : this.getReceivingname().equals(other.getReceivingname()))
            && (this.getTradeserialnumber() == null ? other.getTradeserialnumber() == null : this.getTradeserialnumber().equals(other.getTradeserialnumber()))
            && (this.getNum() == null ? other.getNum() == null : this.getNum().equals(other.getNum()))
            && (this.getPaytype() == null ? other.getPaytype() == null : this.getPaytype().equals(other.getPaytype()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getProductid() == null) ? 0 : getProductid().hashCode());
        result = prime * result + ((getPayamount() == null) ? 0 : getPayamount().hashCode());
        result = prime * result + ((getMerchantid() == null) ? 0 : getMerchantid().hashCode());
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getPaytime() == null) ? 0 : getPaytime().hashCode());
        result = prime * result + ((getPaystatus() == null) ? 0 : getPaystatus().hashCode());
        result = prime * result + ((getReceivingaddress() == null) ? 0 : getReceivingaddress().hashCode());
        result = prime * result + ((getReceivingphone() == null) ? 0 : getReceivingphone().hashCode());
        result = prime * result + ((getReceivingname() == null) ? 0 : getReceivingname().hashCode());
        result = prime * result + ((getTradeserialnumber() == null) ? 0 : getTradeserialnumber().hashCode());
        result = prime * result + ((getNum() == null) ? 0 : getNum().hashCode());
        result = prime * result + ((getPaytype() == null) ? 0 : getPaytype().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", productid=").append(productid);
        sb.append(", payamount=").append(payamount);
        sb.append(", merchantid=").append(merchantid);
        sb.append(", userid=").append(userid);
        sb.append(", createtime=").append(createtime);
        sb.append(", paytime=").append(paytime);
        sb.append(", paystatus=").append(paystatus);
        sb.append(", receivingaddress=").append(receivingaddress);
        sb.append(", receivingphone=").append(receivingphone);
        sb.append(", receivingname=").append(receivingname);
        sb.append(", tradeserialnumber=").append(tradeserialnumber);
        sb.append(", num=").append(num);
        sb.append(", paytype=").append(paytype);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}