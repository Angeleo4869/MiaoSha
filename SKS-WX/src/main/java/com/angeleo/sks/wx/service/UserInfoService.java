package com.angeleo.sks.wx.service;

import com.angeleo.sks.db.pojo.SksUser;
import com.angeleo.sks.db.service.SksUserService;
import com.angeleo.sks.wx.dto.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class UserInfoService {
    @Autowired
    private SksUserService userService;


    public UserInfo getInfo(Integer userId) {
        SksUser user = userService.findById(userId);
        Assert.state(user != null, "用户不存在");
        UserInfo userInfo = new UserInfo();
        userInfo.setNickName(user.getNickname());
        userInfo.setAvatarUrl(user.getAvatar());
        return userInfo;
    }
}
