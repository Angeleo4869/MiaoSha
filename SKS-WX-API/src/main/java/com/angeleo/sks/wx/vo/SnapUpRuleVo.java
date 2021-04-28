package com.angeleo.sks.wx.vo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author leo
 */
public class SnapUpRuleVo {
    private Integer id;
    private String name;
    private String brief;
    private String picUrl;
    private BigDecimal counterPrice;
    private BigDecimal retailPrice;
    private BigDecimal snapupPrice;
    private BigDecimal snapupDiscount;
    private Integer snapupMember;
    private LocalDateTime expireTime;

    public LocalDateTime getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(LocalDateTime expireTime) {
        this.expireTime = expireTime;
    }

    public BigDecimal getSnapUpDiscount() {
        return snapupDiscount;
    }

    public void setSnapUpDiscount(BigDecimal snapupDiscount) {
        this.snapupDiscount = snapupDiscount;
    }

    public Integer getSnapUpMember() {
        return snapupMember;
    }

    public void setSnapUpMember(Integer snapupMember) {
        this.snapupMember = snapupMember;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public BigDecimal getCounterPrice() {
        return counterPrice;
    }

    public void setCounterPrice(BigDecimal counterPrice) {
        this.counterPrice = counterPrice;
    }

    public BigDecimal getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(BigDecimal retailPrice) {
        this.retailPrice = retailPrice;
    }

    public BigDecimal getSnapUpPrice() {
        return snapupPrice;
    }

    public void setSnapUpPrice(BigDecimal snapupPrice) {
        this.snapupPrice = snapupPrice;
    }
}
