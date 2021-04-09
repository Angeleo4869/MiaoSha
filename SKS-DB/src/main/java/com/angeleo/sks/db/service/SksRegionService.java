package com.angeleo.sks.db.service;

import com.angeleo.sks.db.mapper.SksRegionMapper;
import com.angeleo.sks.db.pojo.SksRegion;
import com.angeleo.sks.db.pojo.SksRegionExample;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SksRegionService {

    @Resource
    private SksRegionMapper regionMapper;

    public List<SksRegion> getAll(){
        SksRegionExample example = new SksRegionExample();
        byte b = 4;
        example.or().andTypeNotEqualTo(b);
        return regionMapper.selectByExample(example);
    }

    public List<SksRegion> queryByPid(Integer parentId) {
        SksRegionExample example = new SksRegionExample();
        example.or().andPidEqualTo(parentId);
        return regionMapper.selectByExample(example);
    }

    public SksRegion findById(Integer id) {
        return regionMapper.selectByPrimaryKey(id);
    }

    public List<SksRegion> querySelective(String name, Integer code, Integer page, Integer size, String sort, String order) {
        SksRegionExample example = new SksRegionExample();
        SksRegionExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(name)) {
            criteria.andNameLike("%" + name + "%");
        }
        if (!StringUtils.isEmpty(code)) {
            criteria.andCodeEqualTo(code);
        }

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, size);
        return regionMapper.selectByExample(example);
    }

}
