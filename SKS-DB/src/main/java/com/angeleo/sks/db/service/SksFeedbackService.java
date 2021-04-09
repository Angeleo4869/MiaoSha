package com.angeleo.sks.db.service;

import com.angeleo.sks.db.mapper.SksFeedbackMapper;
import com.angeleo.sks.db.pojo.SksFeedback;
import com.angeleo.sks.db.pojo.SksFeedbackExample;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Yogeek
 * @date 2018/8/27 11:39
 */
@Service
public class SksFeedbackService {
    @Autowired
    private SksFeedbackMapper feedbackMapper;

    public Integer add(SksFeedback feedback) {
        feedback.setAddTime(LocalDateTime.now());
        feedback.setUpdateTime(LocalDateTime.now());
        return feedbackMapper.insertSelective(feedback);
    }

    public List<SksFeedback> querySelective(Integer userId, String username, Integer page, Integer limit, String sort, String order) {
        SksFeedbackExample example = new SksFeedbackExample();
        SksFeedbackExample.Criteria criteria = example.createCriteria();

        if (userId != null) {
            criteria.andUserIdEqualTo(userId);
        }
        if (!StringUtils.isEmpty(username)) {
            criteria.andUsernameLike("%" + username + "%");
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, limit);
        return feedbackMapper.selectByExample(example);
    }
}
