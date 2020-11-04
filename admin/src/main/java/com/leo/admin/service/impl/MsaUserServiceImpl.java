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

    @Autowired
    private MsaUserMapper msaUserMapper;

    @Override
    public MsaUser adminLogin(MasUser user) {
        // TODO Auto-generated method stub
        return msaUserMapper.selectLogin((MsaUser) user);
    }
}
