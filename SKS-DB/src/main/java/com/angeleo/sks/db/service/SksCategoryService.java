package com.angeleo.sks.db.service;

import com.angeleo.sks.db.mapper.SksCategoryMapper;
import com.angeleo.sks.db.pojo.SksCategory;
import com.angeleo.sks.db.pojo.SksCategoryExample;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class SksCategoryService {
    @Resource
    private SksCategoryMapper categoryMapper;
    private SksCategory.Column[] CHANNEL = {SksCategory.Column.id, SksCategory.Column.name, SksCategory.Column.iconUrl};

    public List<SksCategory> queryL1WithoutRecommend(int offset, int limit) {
        SksCategoryExample example = new SksCategoryExample();
        example.or().andLevelEqualTo("L1").andNameNotEqualTo("推荐").andDeletedEqualTo(false);
        PageHelper.startPage(offset, limit);
        return categoryMapper.selectByExample(example);
    }

    public List<SksCategory> queryL1(int offset, int limit) {
        SksCategoryExample example = new SksCategoryExample();
        example.or().andLevelEqualTo("L1").andDeletedEqualTo(false);
        PageHelper.startPage(offset, limit);
        return categoryMapper.selectByExample(example);
    }

    public List<SksCategory> queryL1() {
        SksCategoryExample example = new SksCategoryExample();
        example.or().andLevelEqualTo("L1").andDeletedEqualTo(false);
        return categoryMapper.selectByExample(example);
    }

    public List<SksCategory> queryByPid(Integer pid) {
        SksCategoryExample example = new SksCategoryExample();
        example.or().andPidEqualTo(pid).andDeletedEqualTo(false);
        return categoryMapper.selectByExample(example);
    }

    public List<SksCategory> queryL2ByIds(List<Integer> ids) {
        SksCategoryExample example = new SksCategoryExample();
        example.or().andIdIn(ids).andLevelEqualTo("L2").andDeletedEqualTo(false);
        return categoryMapper.selectByExample(example);
    }

    public SksCategory findById(Integer id) {
        return categoryMapper.selectByPrimaryKey(id);
    }

    public List<SksCategory> querySelective(String id, String name, Integer page, Integer size, String sort, String order) {
        SksCategoryExample example = new SksCategoryExample();
        SksCategoryExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(id)) {
            criteria.andIdEqualTo(Integer.valueOf(id));
        }
        if (!StringUtils.isEmpty(name)) {
            criteria.andNameLike("%" + name + "%");
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, size);
        return categoryMapper.selectByExample(example);
    }

    public int updateById(SksCategory category) {
        category.setUpdateTime(LocalDateTime.now());
        return categoryMapper.updateByPrimaryKeySelective(category);
    }

    public void deleteById(Integer id) {
        categoryMapper.logicalDeleteByPrimaryKey(id);
    }

    public void add(SksCategory category) {
        category.setAddTime(LocalDateTime.now());
        category.setUpdateTime(LocalDateTime.now());
        categoryMapper.insertSelective(category);
    }

    public List<SksCategory> queryChannel() {
        SksCategoryExample example = new SksCategoryExample();
        example.or().andLevelEqualTo("L1").andDeletedEqualTo(false);
        return categoryMapper.selectByExampleSelective(example, CHANNEL);
    }
}
