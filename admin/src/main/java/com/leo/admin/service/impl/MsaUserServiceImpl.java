package com.leo.admin.service.impl;

import com.leo.admin.mapper.MsaUserMapper;
import com.leo.admin.service.MsaUserService;
import com.leo.admin.pojo.MsaUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author leo
 */
@Service(value="userService")
public class MsaUserServiceImpl<MasUser> implements MsaUserService<MsaUser> {

    MsaUserMapper msaUserMapper;
    @Override
    public MsaUser adminLogin(MsaUser user) {
        return msaUserMapper.selectLogin(user);
    }
}
