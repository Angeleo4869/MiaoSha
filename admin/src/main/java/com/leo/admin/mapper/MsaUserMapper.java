package com.leo.admin.mapper;

import com.leo.admin.pojo.MsaUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author leo
 */
@Mapper
public interface MsaUserMapper {
    /**
     * 数据库查询用户登录
     * @param user
     * @return MsaUser
     */
    public MsaUser selectLogin(MsaUser user);

    /**
     * 查询所有用户
     * @return MsaUser
     */
    public MsaUser selectAll();
}
