package com.angeleo.sks.db.service;

import com.alibaba.druid.util.StringUtils;
import com.angeleo.sks.db.mapper.SksSnapUpRulesMapper;
import com.angeleo.sks.db.pojo.SksSnapUpRules;
import com.angeleo.sks.db.pojo.SksSnapUpRulesExample;
import com.angeleo.sks.db.util.SnapUpConstant;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author leo
 */
@Service
public class SksSnapUpRulesService {
    @Resource
    private SksSnapUpRulesMapper mapper;

    public int createRules(SksSnapUpRules rules) {
        rules.setAddTime(LocalDateTime.now());
        rules.setUpdateTime(LocalDateTime.now());
        return mapper.insertSelective(rules);
    }

    /**
     * 根据ID查找对应秒杀项
     *
     * @param: id
     * @return:
     */
    public SksSnapUpRules findById(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }

    /**
     * 查询某个商品关联的秒杀规则
     *
     * @param: goodsId
     * @return:
     */
    public List<SksSnapUpRules> queryByGoodsId(Integer goodsId) {
        SksSnapUpRulesExample example = new SksSnapUpRulesExample();
        example.or().andGoodsIdEqualTo(goodsId).andStatusEqualTo(SnapUpConstant.RULE_STATUS_ON).andDeletedEqualTo(false);
        return mapper.selectByExample(example);
    }

    public int countByGoodsId(Integer goodsId) {
        SksSnapUpRulesExample example = new SksSnapUpRulesExample();
        example.or().andGoodsIdEqualTo(goodsId).andStatusEqualTo(SnapUpConstant.RULE_STATUS_ON).andDeletedEqualTo(false);
        return (int)mapper.countByExample(example);
    }

    public List<SksSnapUpRules> queryByStatus(Short status) {
        SksSnapUpRulesExample example = new SksSnapUpRulesExample();
        example.or().andStatusEqualTo(status).andDeletedEqualTo(false);
        return mapper.selectByExample(example);
    }

    /**
     * 获取首页秒杀规则列表
     *
     * @param: page
     * @param: limit
     * @return:
     */
    public List<SksSnapUpRules> queryList(Integer page, Integer limit) {
        return queryList(page, limit, "add_time", "desc");
    }

    public List<SksSnapUpRules> queryList(Integer page, Integer limit, String sort, String order) {
        SksSnapUpRulesExample example = new SksSnapUpRulesExample();
        example.or().andStatusEqualTo(SnapUpConstant.RULE_STATUS_ON).andDeletedEqualTo(false);
        example.setOrderByClause(sort + " " + order);
        PageHelper.startPage(page, limit);
        return mapper.selectByExample(example);
    }

    /**
     * 判断某个秒杀规则是否已经过期
     *
     * @return:
     */
    public boolean isExpired(SksSnapUpRules rules) {
        return (rules == null || rules.getExpireTime().isBefore(LocalDateTime.now()));
    }

    /**
     * 获取秒杀规则列表
     *
     * @param: goodsId
     * @param: page
     * @param: size
     * @param: sort
     * @param: order
     * @return:
     */
    public List<SksSnapUpRules> querySelective(String goodsId, Integer page, Integer size, String sort, String order) {
        SksSnapUpRulesExample example = new SksSnapUpRulesExample();
        example.setOrderByClause(sort + " " + order);

        SksSnapUpRulesExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(goodsId)) {
            criteria.andGoodsIdEqualTo(Integer.parseInt(goodsId));
        }
        criteria.andDeletedEqualTo(false);

        PageHelper.startPage(page, size);
        return mapper.selectByExample(example);
    }

    public void delete(Integer id) {
        mapper.logicalDeleteByPrimaryKey(id);
    }

    public int updateById(SksSnapUpRules snapupRules) {
        snapupRules.setUpdateTime(LocalDateTime.now());
        return mapper.updateByPrimaryKeySelective(snapupRules);
    }
}