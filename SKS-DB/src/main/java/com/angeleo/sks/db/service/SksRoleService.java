package com.angeleo.sks.db.service;

import com.alibaba.druid.util.StringUtils;
import com.angeleo.sks.db.mapper.SksRoleMapper;
import com.angeleo.sks.db.pojo.SksRole;
import com.angeleo.sks.db.pojo.SksRoleExample;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class SksRoleService {
    @Resource
    private SksRoleMapper roleMapper;


    public Set<String> queryByIds(Integer[] roleIds) {
        Set<String> roles = new HashSet<String>();
        if(roleIds.length == 0){
            return roles;
        }

        SksRoleExample example = new SksRoleExample();
        example.or().andIdIn(Arrays.asList(roleIds)).andEnabledEqualTo(true).andDeletedEqualTo(false);
        List<SksRole> roleList = roleMapper.selectByExample(example);

        for(SksRole role : roleList){
            roles.add(role.getName());
        }

        return roles;

    }

    public List<SksRole> querySelective(String name, Integer page, Integer limit, String sort, String order) {
        SksRoleExample example = new SksRoleExample();
        SksRoleExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(name)) {
            criteria.andNameLike("%" + name + "%");
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, limit);
        return roleMapper.selectByExample(example);
    }

    public SksRole findById(Integer id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    public void add(SksRole role) {
        role.setAddTime(LocalDateTime.now());
        role.setUpdateTime(LocalDateTime.now());
        roleMapper.insertSelective(role);
    }

    public void deleteById(Integer id) {
        roleMapper.logicalDeleteByPrimaryKey(id);
    }

    public void updateById(SksRole role) {
        role.setUpdateTime(LocalDateTime.now());
        roleMapper.updateByPrimaryKeySelective(role);
    }

    public boolean checkExist(String name) {
        SksRoleExample example = new SksRoleExample();
        example.or().andNameEqualTo(name).andDeletedEqualTo(false);
        return roleMapper.countByExample(example) != 0;
    }

    public List<SksRole> queryAll() {
        SksRoleExample example = new SksRoleExample();
        example.or().andDeletedEqualTo(false);
        return roleMapper.selectByExample(example);
    }
}
