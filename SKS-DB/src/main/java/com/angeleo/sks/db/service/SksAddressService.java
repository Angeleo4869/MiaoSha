package com.angeleo.sks.db.service;

import com.angeleo.sks.db.mapper.SksAddressMapper;
import com.angeleo.sks.db.pojo.SksAddress;
import com.angeleo.sks.db.pojo.SksAddressExample;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class SksAddressService {
    @Resource
    private SksAddressMapper addressMapper;

    public List<SksAddress> queryByUid(Integer uid) {
        SksAddressExample example = new SksAddressExample();
        example.or().andUserIdEqualTo(uid).andDeletedEqualTo(false);
        return addressMapper.selectByExample(example);
    }

    public SksAddress query(Integer userId, Integer id) {
        SksAddressExample example = new SksAddressExample();
        example.or().andIdEqualTo(id).andUserIdEqualTo(userId).andDeletedEqualTo(false);
        return addressMapper.selectOneByExample(example);
    }

    public int add(SksAddress address) {
        address.setAddTime(LocalDateTime.now());
        address.setUpdateTime(LocalDateTime.now());
        return addressMapper.insertSelective(address);
    }

    public int update(SksAddress address) {
        address.setUpdateTime(LocalDateTime.now());
        return addressMapper.updateByPrimaryKeySelective(address);
    }

    public void delete(Integer id) {
        addressMapper.logicalDeleteByPrimaryKey(id);
    }

    public SksAddress findDefault(Integer userId) {
        SksAddressExample example = new SksAddressExample();
        example.or().andUserIdEqualTo(userId).andIsDefaultEqualTo(true).andDeletedEqualTo(false);
        return addressMapper.selectOneByExample(example);
    }

    public void resetDefault(Integer userId) {
        SksAddress address = new SksAddress();
        address.setIsDefault(false);
        address.setUpdateTime(LocalDateTime.now());
        SksAddressExample example = new SksAddressExample();
        example.or().andUserIdEqualTo(userId).andDeletedEqualTo(false);
        addressMapper.updateByExampleSelective(address, example);
    }

    public List<SksAddress> querySelective(Integer userId, String name, Integer page, Integer limit, String sort, String order) {
        SksAddressExample example = new SksAddressExample();
        SksAddressExample.Criteria criteria = example.createCriteria();

        if (userId != null) {
            criteria.andUserIdEqualTo(userId);
        }
        if (!StringUtils.isEmpty(name)) {
            criteria.andNameLike("%" + name + "%");
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, limit);
        return addressMapper.selectByExample(example);
    }
}
