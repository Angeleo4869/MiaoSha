package com.angeleo.sks.wx.service;

import com.angeleo.sks.db.pojo.SksSnapUpRules;
import com.github.pagehelper.Page;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.angeleo.sks.db.pojo.SksGoods;
import com.angeleo.sks.db.service.SksGoodsService;
import com.angeleo.sks.db.service.SksSnapUpRulesService;
import com.angeleo.sks.db.service.SksSnapUpService;
import com.angeleo.sks.wx.vo.SnapUpRuleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author leo
 */
@Service
public class WxSnapUpRuleService {
    private final Log logger = LogFactory.getLog(WxSnapUpRuleService.class);

    @Autowired
    private SksSnapUpRulesService snapupRulesService;
    @Autowired
    private SksSnapUpService snapupService;
    @Autowired
    private SksGoodsService goodsService;


    public List<SnapUpRuleVo> queryList(Integer page, Integer size) {
        return queryList(page, size, "add_time", "desc");
    }


    public List<SnapUpRuleVo> queryList(Integer page, Integer size, String sort, String order) {
        Page<SksSnapUpRules> snapupRulesList = (Page<SksSnapUpRules>)snapupRulesService.queryList(page, size, sort, order);

        Page<SnapUpRuleVo> snapupList = new Page<SnapUpRuleVo>();
        snapupList.setPages(snapupRulesList.getPages());
        snapupList.setPageNum(snapupRulesList.getPageNum());
        snapupList.setPageSize(snapupRulesList.getPageSize());
        snapupList.setTotal(snapupRulesList.getTotal());

        for (SksSnapUpRules rule : snapupRulesList) {
            Integer goodsId = rule.getGoodsId();
            SksGoods goods = goodsService.findById(goodsId);
            if (goods == null) {
                continue;
            }

            SnapUpRuleVo snapupRuleVo = new SnapUpRuleVo();
            snapupRuleVo.setId(goods.getId());
            snapupRuleVo.setName(goods.getName());
            snapupRuleVo.setBrief(goods.getBrief());
            snapupRuleVo.setPicUrl(goods.getPicUrl());
            snapupRuleVo.setCounterPrice(goods.getCounterPrice());
            snapupRuleVo.setRetailPrice(goods.getRetailPrice());
            snapupRuleVo.setSnapUpPrice(goods.getRetailPrice().subtract(rule.getDiscount()));
            snapupRuleVo.setSnapUpDiscount(rule.getDiscount());
            snapupRuleVo.setSnapUpMember(rule.getDiscountMember());
            snapupRuleVo.setExpireTime(rule.getExpireTime());
            snapupList.add(snapupRuleVo);
        }

        return snapupList;
    }
}