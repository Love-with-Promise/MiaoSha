package com.bean;

import java.io.Serializable;
import java.util.Date;

public class Msproductinfo implements Serializable {
    private Integer id;

    private Integer productid;

    private String producttitle;

    private String productpicture;

    private Integer originalprice;

    private Integer miaoshaprie;

    private Integer merchantid;

    private Date applydate;

    private Date auditdate;

    private Integer auditstate;//审核转态1,未审核，2，审核通过，3，审核不通过

    private Date starttime;

    private Date endtime;

    private Integer productcount;

    private Integer stockcount;

    private String description;

    private String startTimeString;//开始时间string
    private String endTimeString;//结束时间string

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

    public String getProducttitle() {
        return producttitle;
    }

    public void setProducttitle(String producttitle) {
        this.producttitle = producttitle == null ? null : producttitle.trim();
    }

    public String getProductpicture() {
        return productpicture;
    }

    public void setProductpicture(String productpicture) {
        this.productpicture = productpicture == null ? null : productpicture.trim();
    }

    public Integer getOriginalprice() {
        return originalprice;
    }

    public void setOriginalprice(Integer originalprice) {
        this.originalprice = originalprice;
    }

    public Integer getMiaoshaprie() {
        return miaoshaprie;
    }

    public void setMiaoshaprie(Integer miaoshaprie) {
        this.miaoshaprie = miaoshaprie;
    }

    public Integer getMerchantid() {
        return merchantid;
    }

    public void setMerchantid(Integer merchantid) {
        this.merchantid = merchantid;
    }

    public Date getApplydate() {
        return applydate;
    }

    public void setApplydate(Date applydate) {
        this.applydate = applydate;
    }

    public Date getAuditdate() {
        return auditdate;
    }

    public void setAuditdate(Date auditdate) {
        this.auditdate = auditdate;
    }

    public Integer getAuditstate() {
        return auditstate;
    }

    public void setAuditstate(Integer auditstate) {
        this.auditstate = auditstate;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Integer getProductcount() {
        return productcount;
    }

    public void setProductcount(Integer productcount) {
        this.productcount = productcount;
    }

    public Integer getStockcount() {
        return stockcount;
    }

    public void setStockcount(Integer stockcount) {
        this.stockcount = stockcount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getStartTimeString() {
        return startTimeString;
    }

    public void setStartTimeString(String startTimeString) {
        this.startTimeString = startTimeString;
    }

    public String getEndTimeString() {
        return endTimeString;
    }

    public void setEndTimeString(String endTimeString) {
        this.endTimeString = endTimeString;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Msproductinfo that = (Msproductinfo) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (productid != null ? !productid.equals(that.productid) : that.productid != null) return false;
        if (producttitle != null ? !producttitle.equals(that.producttitle) : that.producttitle != null) return false;
        if (productpicture != null ? !productpicture.equals(that.productpicture) : that.productpicture != null)
            return false;
        if (originalprice != null ? !originalprice.equals(that.originalprice) : that.originalprice != null)
            return false;
        if (miaoshaprie != null ? !miaoshaprie.equals(that.miaoshaprie) : that.miaoshaprie != null) return false;
        if (merchantid != null ? !merchantid.equals(that.merchantid) : that.merchantid != null) return false;
        if (applydate != null ? !applydate.equals(that.applydate) : that.applydate != null) return false;
        if (auditdate != null ? !auditdate.equals(that.auditdate) : that.auditdate != null) return false;
        if (auditstate != null ? !auditstate.equals(that.auditstate) : that.auditstate != null) return false;
        if (starttime != null ? !starttime.equals(that.starttime) : that.starttime != null) return false;
        if (endtime != null ? !endtime.equals(that.endtime) : that.endtime != null) return false;
        if (productcount != null ? !productcount.equals(that.productcount) : that.productcount != null) return false;
        if (stockcount != null ? !stockcount.equals(that.stockcount) : that.stockcount != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (startTimeString != null ? !startTimeString.equals(that.startTimeString) : that.startTimeString != null)
            return false;
        return endTimeString != null ? endTimeString.equals(that.endTimeString) : that.endTimeString == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (productid != null ? productid.hashCode() : 0);
        result = 31 * result + (producttitle != null ? producttitle.hashCode() : 0);
        result = 31 * result + (productpicture != null ? productpicture.hashCode() : 0);
        result = 31 * result + (originalprice != null ? originalprice.hashCode() : 0);
        result = 31 * result + (miaoshaprie != null ? miaoshaprie.hashCode() : 0);
        result = 31 * result + (merchantid != null ? merchantid.hashCode() : 0);
        result = 31 * result + (applydate != null ? applydate.hashCode() : 0);
        result = 31 * result + (auditdate != null ? auditdate.hashCode() : 0);
        result = 31 * result + (auditstate != null ? auditstate.hashCode() : 0);
        result = 31 * result + (starttime != null ? starttime.hashCode() : 0);
        result = 31 * result + (endtime != null ? endtime.hashCode() : 0);
        result = 31 * result + (productcount != null ? productcount.hashCode() : 0);
        result = 31 * result + (stockcount != null ? stockcount.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (startTimeString != null ? startTimeString.hashCode() : 0);
        result = 31 * result + (endTimeString != null ? endTimeString.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Msproductinfo{" +
                "id=" + id +
                ", productid=" + productid +
                ", producttitle='" + producttitle + '\'' +
                ", productpicture='" + productpicture + '\'' +
                ", originalprice=" + originalprice +
                ", miaoshaprie=" + miaoshaprie +
                ", merchantid=" + merchantid +
                ", applydate=" + applydate +
                ", auditdate=" + auditdate +
                ", auditstate=" + auditstate +
                ", starttime=" + starttime +
                ", endtime=" + endtime +
                ", productcount=" + productcount +
                ", stockcount=" + stockcount +
                ", description='" + description + '\'' +
                ", startTimeString='" + startTimeString + '\'' +
                ", endTimeString='" + endTimeString + '\'' +
                '}';
    }
}