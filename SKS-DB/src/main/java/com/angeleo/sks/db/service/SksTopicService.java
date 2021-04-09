package com.angeleo.sks.db.service;

import com.angeleo.sks.db.mapper.SksTopicMapper;
import com.angeleo.sks.db.pojo.SksTopic;
import com.angeleo.sks.db.pojo.SksTopic.Column;
import com.angeleo.sks.db.pojo.SksTopicExample;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class SksTopicService {
    @Resource
    private SksTopicMapper topicMapper;
    private SksTopic.Column[] columns = new Column[]{Column.id, Column.title, Column.subtitle, Column.price, Column.picUrl, Column.readCount};

    public List<SksTopic> queryList(int offset, int limit) {
        return queryList(offset, limit, "add_time", "desc");
    }

    public List<SksTopic> queryList(int offset, int limit, String sort, String order) {
        SksTopicExample example = new SksTopicExample();
        example.or().andDeletedEqualTo(false);
        example.setOrderByClause(sort + " " + order);
        PageHelper.startPage(offset, limit);
        return topicMapper.selectByExampleSelective(example, columns);
    }

    public int queryTotal() {
        SksTopicExample example = new SksTopicExample();
        example.or().andDeletedEqualTo(false);
        return (int) topicMapper.countByExample(example);
    }

    public SksTopic findById(Integer id) {
        SksTopicExample example = new SksTopicExample();
        example.or().andIdEqualTo(id).andDeletedEqualTo(false);
        return topicMapper.selectOneByExampleWithBLOBs(example);
    }

    public List<SksTopic> queryRelatedList(Integer id, int offset, int limit) {
        SksTopicExample example = new SksTopicExample();
        example.or().andIdEqualTo(id).andDeletedEqualTo(false);
        List<SksTopic> topics = topicMapper.selectByExample(example);
        if (topics.size() == 0) {
            return queryList(offset, limit, "add_time", "desc");
        }
        SksTopic topic = topics.get(0);

        example = new SksTopicExample();
        example.or().andIdNotEqualTo(topic.getId()).andDeletedEqualTo(false);
        PageHelper.startPage(offset, limit);
        List<SksTopic> relateds = topicMapper.selectByExampleWithBLOBs(example);
        if (relateds.size() != 0) {
            return relateds;
        }

        return queryList(offset, limit, "add_time", "desc");
    }

    public List<SksTopic> querySelective(String title, String subtitle, Integer page, Integer limit, String sort, String order) {
        SksTopicExample example = new SksTopicExample();
        SksTopicExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(title)) {
            criteria.andTitleLike("%" + title + "%");
        }
        if (!StringUtils.isEmpty(subtitle)) {
            criteria.andSubtitleLike("%" + subtitle + "%");
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, limit);
        return topicMapper.selectByExampleWithBLOBs(example);
    }

    public int updateById(SksTopic topic) {
        topic.setUpdateTime(LocalDateTime.now());
        SksTopicExample example = new SksTopicExample();
        example.or().andIdEqualTo(topic.getId());
        return topicMapper.updateByExampleSelective(topic, example);
    }

    public void deleteById(Integer id) {
        topicMapper.logicalDeleteByPrimaryKey(id);
    }

    public void add(SksTopic topic) {
        topic.setAddTime(LocalDateTime.now());
        topic.setUpdateTime(LocalDateTime.now());
        topicMapper.insertSelective(topic);
    }


    public void deleteByIds(List<Integer> ids) {
        SksTopicExample example = new SksTopicExample();
        example.or().andIdIn(ids).andDeletedEqualTo(false);
        SksTopic topic = new SksTopic();
        topic.setUpdateTime(LocalDateTime.now());
        topic.setDeleted(true);
        topicMapper.updateByExampleSelective(topic, example);
    }
}
