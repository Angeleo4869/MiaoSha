package com.angeleo.sks.db.service;

import com.alibaba.druid.util.StringUtils;
import com.angeleo.sks.db.mapper.SksGoodsMapper;
import com.angeleo.sks.db.mapper.SksGrouponRulesMapper;
import com.angeleo.sks.db.pojo.SksGoods;
import com.angeleo.sks.db.pojo.SksGrouponRules;
import com.angeleo.sks.db.pojo.SksGrouponRulesExample;
import com.angeleo.sks.db.util.GrouponConstant;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class SksGrouponRulesService {
    @Resource
    private SksGrouponRulesMapper mapper;
    @Resource
    private SksGoodsMapper goodsMapper;
    private SksGoods.Column[] goodsColumns = new SksGoods.Column[]{SksGoods.Column.id, SksGoods.Column.name, SksGoods.Column.brief, SksGoods.Column.picUrl, SksGoods.Column.counterPrice, SksGoods.Column.retailPrice};

    public int createRules(SksGrouponRules rules) {
        rules.setAddTime(LocalDateTime.now());
        rules.setUpdateTime(LocalDateTime.now());
        return mapper.insertSelective(rules);
    }

    /**
     * 根据ID查找对应团购项
     *
     * @param id
     * @return
     */
    public SksGrouponRules findById(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }

    /**
     * 查询某个商品关联的团购规则
     *
     * @param goodsId
     * @return
     */
    public List<SksGrouponRules> queryByGoodsId(Integer goodsId) {
        SksGrouponRulesExample example = new SksGrouponRulesExample();
        example.or().andGoodsIdEqualTo(goodsId).andStatusEqualTo(GrouponConstant.RULE_STATUS_ON).andDeletedEqualTo(false);
        return mapper.selectByExample(example);
    }

    public int countByGoodsId(Integer goodsId) {
        SksGrouponRulesExample example = new SksGrouponRulesExample();
        example.or().andGoodsIdEqualTo(goodsId).andStatusEqualTo(GrouponConstant.RULE_STATUS_ON).andDeletedEqualTo(false);
        return (int)mapper.countByExample(example);
    }

    public List<SksGrouponRules> queryByStatus(Short status) {
        SksGrouponRulesExample example = new SksGrouponRulesExample();
        example.or().andStatusEqualTo(status).andDeletedEqualTo(false);
        return mapper.selectByExample(example);
    }

    /**
     * 获取首页团购规则列表
     *
     * @param page
     * @param limit
     * @return
     */
    public List<SksGrouponRules> queryList(Integer page, Integer limit) {
        return queryList(page, limit, "add_time", "desc");
    }

    public List<SksGrouponRules> queryList(Integer page, Integer limit, String sort, String order) {
        SksGrouponRulesExample example = new SksGrouponRulesExample();
        example.or().andStatusEqualTo(GrouponConstant.RULE_STATUS_ON).andDeletedEqualTo(false);
        example.setOrderByClause(sort + " " + order);
        PageHelper.startPage(page, limit);
        return mapper.selectByExample(example);
    }

    /**
     * 判断某个团购规则是否已经过期
     *
     * @return
     */
    public boolean isExpired(SksGrouponRules rules) {
        return (rules == null || rules.getExpireTime().isBefore(LocalDateTime.now()));
    }

    /**
     * 获取团购规则列表
     *
     * @param goodsId
     * @param page
     * @param size
     * @param sort
     * @param order
     * @return
     */
    public List<SksGrouponRules> querySelective(String goodsId, Integer page, Integer size, String sort, String order) {
        SksGrouponRulesExample example = new SksGrouponRulesExample();
        example.setOrderByClause(sort + " " + order);

        SksGrouponRulesExample.Criteria criteria = example.createCriteria();

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

    public int updateById(SksGrouponRules grouponRules) {
        grouponRules.setUpdateTime(LocalDateTime.now());
        return mapper.updateByPrimaryKeySelective(grouponRules);
    }
}