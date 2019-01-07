package com.bean;

import java.io.Serializable;

public class Msmerchant implements Serializable {
    private Integer id;

    private String merchantname;

    private String merchantshopname;

    private String merchantaccount;

    private String merchantpassword;

    private String merchantscope;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMerchantname() {
        return merchantname;
    }

    public void setMerchantname(String merchantname) {
        this.merchantname = merchantname == null ? null : merchantname.trim();
    }

    public String getMerchantshopname() {
        return merchantshopname;
    }

    public void setMerchantshopname(String merchantshopname) {
        this.merchantshopname = merchantshopname == null ? null : merchantshopname.trim();
    }

    public String getMerchantaccount() {
        return merchantaccount;
    }

    public void setMerchantaccount(String merchantaccount) {
        this.merchantaccount = merchantaccount == null ? null : merchantaccount.trim();
    }

    public String getMerchantpassword() {
        return merchantpassword;
    }

    public void setMerchantpassword(String merchantpassword) {
        this.merchantpassword = merchantpassword == null ? null : merchantpassword.trim();
    }

    public String getMerchantscope() {
        return merchantscope;
    }

    public void setMerchantscope(String merchantscope) {
        this.merchantscope = merchantscope == null ? null : merchantscope.trim();
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
        Msmerchant other = (Msmerchant) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getMerchantname() == null ? other.getMerchantname() == null : this.getMerchantname().equals(other.getMerchantname()))
            && (this.getMerchantshopname() == null ? other.getMerchantshopname() == null : this.getMerchantshopname().equals(other.getMerchantshopname()))
            && (this.getMerchantaccount() == null ? other.getMerchantaccount() == null : this.getMerchantaccount().equals(other.getMerchantaccount()))
            && (this.getMerchantpassword() == null ? other.getMerchantpassword() == null : this.getMerchantpassword().equals(other.getMerchantpassword()))
            && (this.getMerchantscope() == null ? other.getMerchantscope() == null : this.getMerchantscope().equals(other.getMerchantscope()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getMerchantname() == null) ? 0 : getMerchantname().hashCode());
        result = prime * result + ((getMerchantshopname() == null) ? 0 : getMerchantshopname().hashCode());
        result = prime * result + ((getMerchantaccount() == null) ? 0 : getMerchantaccount().hashCode());
        result = prime * result + ((getMerchantpassword() == null) ? 0 : getMerchantpassword().hashCode());
        result = prime * result + ((getMerchantscope() == null) ? 0 : getMerchantscope().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", merchantname=").append(merchantname);
        sb.append(", merchantshopname=").append(merchantshopname);
        sb.append(", merchantaccount=").append(merchantaccount);
        sb.append(", merchantpassword=").append(merchantpassword);
        sb.append(", merchantscope=").append(merchantscope);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}