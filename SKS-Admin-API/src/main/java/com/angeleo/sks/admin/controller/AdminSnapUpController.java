package com.angeleo.sks.admin.controller;

import com.angeleo.sks.admin.annotation.RequiresPermissionsDesc;
import com.angeleo.sks.admin.task.SnapUpRuleExpiredTask;
import com.angeleo.sks.admin.util.AdminResponseCode;
import com.angeleo.sks.core.task.TaskService;
import com.angeleo.sks.core.util.ResponseUtil;
import com.angeleo.sks.core.validator.Order;
import com.angeleo.sks.core.validator.Sort;
import com.angeleo.sks.db.pojo.SksGoods;
import com.angeleo.sks.db.pojo.SksSnapUp;
import com.angeleo.sks.db.pojo.SksSnapUpRules;
import com.angeleo.sks.db.service.SksGoodsService;
import com.angeleo.sks.db.service.SksSnapUpRulesService;
import com.angeleo.sks.db.service.SksSnapUpService;
import com.angeleo.sks.db.util.SnapUpConstant;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin/sanpup")
@Validated
public class AdminSnapUpController {
    private final Log logger = LogFactory.getLog(AdminSnapUpController.class);

    @Autowired
    private SksSnapUpRulesService rulesService;
    @Autowired
    private SksGoodsService goodsService;
    @Autowired
    private SksSnapUpService sanpupService;
    @Autowired
    private TaskService taskService;

    @RequiresPermissions("admin:sanpup:read")
    @RequiresPermissionsDesc(menu = {"推广管理", "秒杀管理"}, button = "详情")
    @GetMapping("/listRecord")
    public Object listRecord(String sanpupRuleId,
                             @RequestParam(defaultValue = "1") Integer page,
                             @RequestParam(defaultValue = "10") Integer limit,
                             @Sort @RequestParam(defaultValue = "add_time") String sort,
                             @Order @RequestParam(defaultValue = "desc") String order) {
        List<SksSnapUp> sanpupList = sanpupService.querySelective(sanpupRuleId, page, limit, sort, order);

        List<Map<String, Object>> sanpups = new ArrayList<>();
        for (SksSnapUp sanpup : sanpupList) {
            try {
                Map<String, Object> recordData = new HashMap<>();
                List<SksSnapUp> subSnapUpList = sanpupService.queryJoinRecord(sanpup.getId());
                SksSnapUpRules rules = rulesService.findById(sanpup.getRulesId());
                SksGoods goods = goodsService.findById(rules.getGoodsId());

                recordData.put("sanpup", sanpup);
                recordData.put("subSnapUps", subSnapUpList);
                recordData.put("rules", rules);
                recordData.put("goods", goods);

                sanpups.add(recordData);
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            }
        }

        return ResponseUtil.okList(sanpups, sanpupList);
    }

    @RequiresPermissions("admin:sanpup:list")
    @RequiresPermissionsDesc(menu = {"推广管理", "秒杀管理"}, button = "查询")
    @GetMapping("/list")
    public Object list(String goodsId,
                       @RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer limit,
                       @Sort @RequestParam(defaultValue = "add_time") String sort,
                       @Order @RequestParam(defaultValue = "desc") String order) {
        List<SksSnapUpRules> rulesList = rulesService.querySelective(goodsId, page, limit, sort, order);
        return ResponseUtil.okList(rulesList);
    }

    private Object validate(SksSnapUpRules sanpupRules) {
        Integer goodsId = sanpupRules.getGoodsId();
        if (goodsId == null) {
            return ResponseUtil.badArgument();
        }
        BigDecimal discount = sanpupRules.getDiscount();
        if (discount == null) {
            return ResponseUtil.badArgument();
        }
        Integer discountMember = sanpupRules.getDiscountMember();
        if (discountMember == null) {
            return ResponseUtil.badArgument();
        }
        LocalDateTime expireTime = sanpupRules.getExpireTime();
        if (expireTime == null) {
            return ResponseUtil.badArgument();
        }

        return null;
    }

    @RequiresPermissions("admin:sanpup:update")
    @RequiresPermissionsDesc(menu = {"推广管理", "秒杀管理"}, button = "编辑")
    @PostMapping("/update")
    public Object update(@RequestBody SksSnapUpRules sanpupRules) {
        Object error = validate(sanpupRules);
        if (error != null) {
            return error;
        }

        SksSnapUpRules rules = rulesService.findById(sanpupRules.getId());
        if(rules == null){
            return ResponseUtil.badArgumentValue();
        }
        if(!rules.getStatus().equals(SnapUpConstant.RULE_STATUS_ON)){
            return ResponseUtil.fail(AdminResponseCode.GROUPON_GOODS_OFFLINE, "秒杀已经下线");
        }

        Integer goodsId = sanpupRules.getGoodsId();
        SksGoods goods = goodsService.findById(goodsId);
        if (goods == null) {
            return ResponseUtil.badArgumentValue();
        }

        sanpupRules.setGoodsName(goods.getName());
        sanpupRules.setPicUrl(goods.getPicUrl());

        if (rulesService.updateById(sanpupRules) == 0) {
            return ResponseUtil.updatedDataFailed();
        }

        return ResponseUtil.ok();
    }

    @RequiresPermissions("admin:sanpup:create")
    @RequiresPermissionsDesc(menu = {"推广管理", "秒杀管理"}, button = "添加")
    @PostMapping("/create")
    public Object create(@RequestBody SksSnapUpRules sanpupRules) {
        Object error = validate(sanpupRules);
        if (error != null) {
            return error;
        }

        Integer goodsId = sanpupRules.getGoodsId();
        SksGoods goods = goodsService.findById(goodsId);
        if (goods == null) {
            return ResponseUtil.fail(AdminResponseCode.GROUPON_GOODS_UNKNOWN, "秒杀商品不存在");
        }
        if(rulesService.countByGoodsId(goodsId) > 0){
            return ResponseUtil.fail(AdminResponseCode.GROUPON_GOODS_EXISTED, "秒杀商品已经存在");
        }

        sanpupRules.setGoodsName(goods.getName());
        sanpupRules.setPicUrl(goods.getPicUrl());
        sanpupRules.setStatus(SnapUpConstant.RULE_STATUS_ON);
        rulesService.createRules(sanpupRules);

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime expire = sanpupRules.getExpireTime();
        long delay = ChronoUnit.MILLIS.between(now, expire);
        // 秒杀过期任务
        taskService.addTask(new SnapUpRuleExpiredTask(sanpupRules.getId(), delay));

        return ResponseUtil.ok(sanpupRules);
    }

    @RequiresPermissions("admin:sanpup:delete")
    @RequiresPermissionsDesc(menu = {"推广管理", "秒杀管理"}, button = "删除")
    @PostMapping("/delete")
    public Object delete(@RequestBody SksSnapUpRules sanpupRules) {
        Integer id = sanpupRules.getId();
        if (id == null) {
            return ResponseUtil.badArgument();
        }

        rulesService.delete(id);
        return ResponseUtil.ok();
    }
}
