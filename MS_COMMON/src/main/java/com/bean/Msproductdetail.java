package com.bean;

import java.io.Serializable;

public class Msproductdetail implements Serializable {
    private Integer id;

    private Integer productid;

    private Integer merchantid;

    private String productplace;

    private String productname;

    private String brandname;

    private Double productweight;

    private String specification;

    private String productdetailpicture;

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

    public Integer getMerchantid() {
        return merchantid;
    }

    public void setMerchantid(Integer merchantid) {
        this.merchantid = merchantid;
    }

    public String getProductplace() {
        return productplace;
    }

    public void setProductplace(String productplace) {
        this.productplace = productplace == null ? null : productplace.trim();
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname == null ? null : productname.trim();
    }

    public String getBrandname() {
        return brandname;
    }

    public void setBrandname(String brandname) {
        this.brandname = brandname == null ? null : brandname.trim();
    }

    public Double getProductweight() {
        return productweight;
    }

    public void setProductweight(Double productweight) {
        this.productweight = productweight;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification == null ? null : specification.trim();
    }

    public String getProductdetailpicture() {
        return productdetailpicture;
    }

    public void setProductdetailpicture(String productdetailpicture) {
        this.productdetailpicture = productdetailpicture == null ? null : productdetailpicture.trim();
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
        Msproductdetail other = (Msproductdetail) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getProductid() == null ? other.getProductid() == null : this.getProductid().equals(other.getProductid()))
            && (this.getMerchantid() == null ? other.getMerchantid() == null : this.getMerchantid().equals(other.getMerchantid()))
            && (this.getProductplace() == null ? other.getProductplace() == null : this.getProductplace().equals(other.getProductplace()))
            && (this.getProductname() == null ? other.getProductname() == null : this.getProductname().equals(other.getProductname()))
            && (this.getBrandname() == null ? other.getBrandname() == null : this.getBrandname().equals(other.getBrandname()))
            && (this.getProductweight() == null ? other.getProductweight() == null : this.getProductweight().equals(other.getProductweight()))
            && (this.getSpecification() == null ? other.getSpecification() == null : this.getSpecification().equals(other.getSpecification()))
            && (this.getProductdetailpicture() == null ? other.getProductdetailpicture() == null : this.getProductdetailpicture().equals(other.getProductdetailpicture()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getProductid() == null) ? 0 : getProductid().hashCode());
        result = prime * result + ((getMerchantid() == null) ? 0 : getMerchantid().hashCode());
        result = prime * result + ((getProductplace() == null) ? 0 : getProductplace().hashCode());
        result = prime * result + ((getProductname() == null) ? 0 : getProductname().hashCode());
        result = prime * result + ((getBrandname() == null) ? 0 : getBrandname().hashCode());
        result = prime * result + ((getProductweight() == null) ? 0 : getProductweight().hashCode());
        result = prime * result + ((getSpecification() == null) ? 0 : getSpecification().hashCode());
        result = prime * result + ((getProductdetailpicture() == null) ? 0 : getProductdetailpicture().hashCode());
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
        sb.append(", merchantid=").append(merchantid);
        sb.append(", productplace=").append(productplace);
        sb.append(", productname=").append(productname);
        sb.append(", brandname=").append(brandname);
        sb.append(", productweight=").append(productweight);
        sb.append(", specification=").append(specification);
        sb.append(", productdetailpicture=").append(productdetailpicture);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}