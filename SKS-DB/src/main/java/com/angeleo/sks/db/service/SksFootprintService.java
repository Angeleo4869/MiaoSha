package com.angeleo.sks.db.service;

import com.angeleo.sks.db.mapper.SksFootprintMapper;
import com.angeleo.sks.db.pojo.SksFootprint;
import com.angeleo.sks.db.pojo.SksFootprintExample;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class SksFootprintService {
    @Resource
    private SksFootprintMapper footprintMapper;

    public List<SksFootprint> queryByAddTime(Integer userId, Integer page, Integer size) {
        SksFootprintExample example = new SksFootprintExample();
        example.or().andUserIdEqualTo(userId).andDeletedEqualTo(false);
        example.setOrderByClause(SksFootprint.Column.addTime.desc());
        PageHelper.startPage(page, size);
        return footprintMapper.selectByExample(example);
    }

    public SksFootprint findById(Integer id) {
        return footprintMapper.selectByPrimaryKey(id);
    }

    public SksFootprint findById(Integer userId, Integer id) {
        SksFootprintExample example = new SksFootprintExample();
        example.or().andIdEqualTo(id).andUserIdEqualTo(userId).andDeletedEqualTo(false);
        return footprintMapper.selectOneByExample(example);
    }

    public void deleteById(Integer id) {
        footprintMapper.logicalDeleteByPrimaryKey(id);
    }

    public void add(SksFootprint footprint) {
        footprint.setAddTime(LocalDateTime.now());
        footprint.setUpdateTime(LocalDateTime.now());
        footprintMapper.insertSelective(footprint);
    }

    public List<SksFootprint> querySelective(String userId, String goodsId, Integer page, Integer size, String sort, String order) {
        SksFootprintExample example = new SksFootprintExample();
        SksFootprintExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(userId)) {
            criteria.andUserIdEqualTo(Integer.valueOf(userId));
        }
        if (!StringUtils.isEmpty(goodsId)) {
            criteria.andGoodsIdEqualTo(Integer.valueOf(goodsId));
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, size);
        return footprintMapper.selectByExample(example);
    }
}
