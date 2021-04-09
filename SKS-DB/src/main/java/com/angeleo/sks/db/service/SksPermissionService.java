package com.angeleo.sks.db.service;

import com.angeleo.sks.db.mapper.SksPermissionMapper;
import com.angeleo.sks.db.pojo.SksPermission;
import com.angeleo.sks.db.pojo.SksPermissionExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class SksPermissionService {
    @Resource
    private SksPermissionMapper permissionMapper;

    public Set<String> queryByRoleIds(Integer[] roleIds) {
        Set<String> permissions = new HashSet<String>();
        if(roleIds.length == 0){
            return permissions;
        }

        SksPermissionExample example = new SksPermissionExample();
        example.or().andRoleIdIn(Arrays.asList(roleIds)).andDeletedEqualTo(false);
        List<SksPermission> permissionList = permissionMapper.selectByExample(example);

        for(SksPermission permission : permissionList){
            permissions.add(permission.getPermission());
        }

        return permissions;
    }


    public Set<String> queryByRoleId(Integer roleId) {
        Set<String> permissions = new HashSet<String>();
        if(roleId == null){
            return permissions;
        }

        SksPermissionExample example = new SksPermissionExample();
        example.or().andRoleIdEqualTo(roleId).andDeletedEqualTo(false);
        List<SksPermission> permissionList = permissionMapper.selectByExample(example);

        for(SksPermission permission : permissionList){
            permissions.add(permission.getPermission());
        }

        return permissions;
    }

    public boolean checkSuperPermission(Integer roleId) {
        if(roleId == null){
            return false;
        }

        SksPermissionExample example = new SksPermissionExample();
        example.or().andRoleIdEqualTo(roleId).andPermissionEqualTo("*").andDeletedEqualTo(false);
        return permissionMapper.countByExample(example) != 0;
    }

    public void deleteByRoleId(Integer roleId) {
        SksPermissionExample example = new SksPermissionExample();
        example.or().andRoleIdEqualTo(roleId).andDeletedEqualTo(false);
        permissionMapper.logicalDeleteByExample(example);
    }

    public void add(SksPermission SksPermission) {
        SksPermission.setAddTime(LocalDateTime.now());
        SksPermission.setUpdateTime(LocalDateTime.now());
        permissionMapper.insertSelective(SksPermission);
    }
}
