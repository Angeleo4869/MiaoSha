package com.leo.admin.service;

import com.leo.admin.pojo.MsaUser;

/**
 * @author leo
 */
public interface MsaUserService<MasUser> {
    /**
     * 登录Service接口
     * @param user 传入User对象
     * @return MasUSer 返回User对象
     */
    public MsaUser adminLogin(MasUser user);


}
