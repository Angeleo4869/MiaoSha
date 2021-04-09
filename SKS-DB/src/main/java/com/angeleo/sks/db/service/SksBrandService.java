package com.angeleo.sks.db.service;

import com.angeleo.sks.db.mapper.SksBrandMapper;
import com.angeleo.sks.db.pojo.SksBrand;
import com.angeleo.sks.db.pojo.SksBrand.Column;
import com.angeleo.sks.db.pojo.SksBrandExample;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class SksBrandService {
    @Resource
    private SksBrandMapper brandMapper;
    private Column[] columns = new Column[]{Column.id, Column.name, Column.desc, Column.picUrl, Column.floorPrice};

    public List<SksBrand> query(Integer page, Integer limit, String sort, String order) {
        SksBrandExample example = new SksBrandExample();
        example.or().andDeletedEqualTo(false);
        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }
        PageHelper.startPage(page, limit);
        return brandMapper.selectByExampleSelective(example, columns);
    }

    public List<SksBrand> query(Integer page, Integer limit) {
        return query(page, limit, null, null);
    }

    public SksBrand findById(Integer id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    public List<SksBrand> querySelective(String id, String name, Integer page, Integer size, String sort, String order) {
        SksBrandExample example = new SksBrandExample();
        SksBrandExample.Criteria criteria = example.createCriteria();

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
        return brandMapper.selectByExample(example);
    }

    public int updateById(SksBrand brand) {
        brand.setUpdateTime(LocalDateTime.now());
        return brandMapper.updateByPrimaryKeySelective(brand);
    }

    public void deleteById(Integer id) {
        brandMapper.logicalDeleteByPrimaryKey(id);
    }

    public void add(SksBrand brand) {
        brand.setAddTime(LocalDateTime.now());
        brand.setUpdateTime(LocalDateTime.now());
        brandMapper.insertSelective(brand);
    }

    public List<SksBrand> all() {
        SksBrandExample example = new SksBrandExample();
        example.or().andDeletedEqualTo(false);
        return brandMapper.selectByExample(example);
    }
}
