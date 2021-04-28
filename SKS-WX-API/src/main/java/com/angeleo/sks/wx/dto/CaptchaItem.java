package com.angeleo.sks.wx.dto;

import java.time.LocalDateTime;

/**
 * 验证码实体类，用于缓存验证码发送
 * @author leo
 */
public class CaptchaItem {
    private String phoneNumber;
    private String code;
    private LocalDateTime expireTime;

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDateTime getExpireTime() {
        return this.expireTime;
    }

    public void setExpireTime(LocalDateTime expireTime) {
        this.expireTime = expireTime;
    }
}