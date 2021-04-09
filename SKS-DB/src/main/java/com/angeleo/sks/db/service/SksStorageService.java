package com.angeleo.sks.db.service;

import com.angeleo.sks.db.mapper.SksStorageMapper;
import com.angeleo.sks.db.pojo.SksStorage;
import com.angeleo.sks.db.pojo.SksStorageExample;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SksStorageService {
    @Autowired
    private SksStorageMapper storageMapper;

    public void deleteByKey(String key) {
        SksStorageExample example = new SksStorageExample();
        example.or().andKeyEqualTo(key);
        storageMapper.logicalDeleteByExample(example);
    }

    public void add(SksStorage storageInfo) {
        storageInfo.setAddTime(LocalDateTime.now());
        storageInfo.setUpdateTime(LocalDateTime.now());
        storageMapper.insertSelective(storageInfo);
    }

    public SksStorage findByKey(String key) {
        SksStorageExample example = new SksStorageExample();
        example.or().andKeyEqualTo(key).andDeletedEqualTo(false);
        return storageMapper.selectOneByExample(example);
    }

    public int update(SksStorage storageInfo) {
        storageInfo.setUpdateTime(LocalDateTime.now());
        return storageMapper.updateByPrimaryKeySelective(storageInfo);
    }

    public SksStorage findById(Integer id) {
        return storageMapper.selectByPrimaryKey(id);
    }

    public List<SksStorage> querySelective(String key, String name, Integer page, Integer limit, String sort, String order) {
        SksStorageExample example = new SksStorageExample();
        SksStorageExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(key)) {
            criteria.andKeyEqualTo(key);
        }
        if (!StringUtils.isEmpty(name)) {
            criteria.andNameLike("%" + name + "%");
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, limit);
        return storageMapper.selectByExample(example);
    }
}
