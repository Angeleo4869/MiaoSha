package com.angeleo.sks.db.service;

import com.angeleo.sks.db.mapper.SksSearchHistoryMapper;
import com.angeleo.sks.db.pojo.SksSearchHistory;
import com.angeleo.sks.db.pojo.SksSearchHistoryExample;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class SksSearchHistoryService {
    @Resource
    private SksSearchHistoryMapper searchHistoryMapper;

    public void save(SksSearchHistory searchHistory) {
        searchHistory.setAddTime(LocalDateTime.now());
        searchHistory.setUpdateTime(LocalDateTime.now());
        searchHistoryMapper.insertSelective(searchHistory);
    }

    public List<SksSearchHistory> queryByUid(int uid) {
        SksSearchHistoryExample example = new SksSearchHistoryExample();
        example.or().andUserIdEqualTo(uid).andDeletedEqualTo(false);
        example.setDistinct(true);
        return searchHistoryMapper.selectByExampleSelective(example, SksSearchHistory.Column.keyword);
    }

    public void deleteByUid(int uid) {
        SksSearchHistoryExample example = new SksSearchHistoryExample();
        example.or().andUserIdEqualTo(uid);
        searchHistoryMapper.logicalDeleteByExample(example);
    }

    public List<SksSearchHistory> querySelective(String userId, String keyword, Integer page, Integer size, String sort, String order) {
        SksSearchHistoryExample example = new SksSearchHistoryExample();
        SksSearchHistoryExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(userId)) {
            criteria.andUserIdEqualTo(Integer.valueOf(userId));
        }
        if (!StringUtils.isEmpty(keyword)) {
            criteria.andKeywordLike("%" + keyword + "%");
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, size);
        return searchHistoryMapper.selectByExample(example);
    }
}
