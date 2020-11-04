package com.leo.admin.mapper;

import com.leo.admin.pojo.MsaUser;
/**
 * @author leo
 */
public interface MsaUserMapper {
    /**
     * 数据库查询用户登录
     * @param user
     * @return
     */
    public MsaUser selectLogin(MsaUser user);
}
