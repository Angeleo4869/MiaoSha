package com.angeleo.sks.wx.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.angeleo.sks.db.pojo.*;
import com.angeleo.sks.db.service.*;
import com.angeleo.sks.core.express.ExpressService;
import com.angeleo.sks.core.express.dao.ExpressInfo;
import com.angeleo.sks.core.util.ResponseUtil;
import com.angeleo.sks.core.validator.Order;
import com.angeleo.sks.core.validator.Sort;
import com.angeleo.sks.db.util.OrderUtil;
import com.angeleo.sks.wx.annotation.LoginUser;
import com.angeleo.sks.wx.service.WxSnapUpRuleService;
import com.angeleo.sks.wx.vo.SnapUpRuleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.angeleo.sks.wx.util.WxResponseCode.*;

/**
 * 团购服务
 * <p>
 * 需要注意这里团购规则和团购活动的关系和区别。
 */
@RestController
@RequestMapping("/wx/snapup")
@Validated
public class WxSnapUpController {
    private final Log logger = LogFactory.getLog(WxSnapUpController.class);

    @Autowired
    private SksSnapUpRulesService rulesService;
    @Autowired
    private WxSnapUpRuleService wxSnapUpRuleService;
    @Autowired
    private SksSnapUpService snapupService;
    @Autowired
    private SksGoodsService goodsService;
    @Autowired
    private SksOrderService orderService;
    @Autowired
    private SksOrderGoodsService orderGoodsService;
    @Autowired
    private SksUserService userService;
    @Autowired
    private ExpressService expressService;
    @Autowired
    private SksSnapUpRulesService snapupRulesService;

    /**
     * 团购规则列表
     *
     * @param page 分页页数
     * @param limit 分页大小
     * @return 团购规则列表
     */
    @GetMapping("list")
    public Object list(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer limit,
                       @Sort @RequestParam(defaultValue = "add_time") String sort,
                       @Order @RequestParam(defaultValue = "desc") String order) {
        List<SnapUpRuleVo> snapupRuleVoList = wxSnapUpRuleService.queryList(page, limit, sort, order);
        return ResponseUtil.okList(snapupRuleVoList);
    }

    /**
     * 团购活动详情
     *
     * @param userId    用户ID
     * @param snapupId 团购活动ID
     * @return 团购活动详情
     */
    @GetMapping("detail")
    public Object detail(@LoginUser Integer userId, @NotNull Integer snapupId) {
        if (userId == null) {
            return ResponseUtil.unlogin();
        }

        SksSnapUp snapup = snapupService.queryById(userId, snapupId);
        if (snapup == null) {
            return ResponseUtil.badArgumentValue();
        }

        SksSnapUpRules rules = rulesService.findById(snapup.getRulesId());
        if (rules == null) {
            return ResponseUtil.badArgumentValue();
        }

        // 订单信息
        SksOrder order = orderService.findById(userId, snapup.getOrderId());
        if (null == order) {
            return ResponseUtil.fail(ORDER_UNKNOWN, "订单不存在");
        }
        if (!order.getUserId().equals(userId)) {
            return ResponseUtil.fail(ORDER_INVALID, "不是当前用户的订单");
        }
        Map<String, Object> orderVo = new HashMap<String, Object>();
        orderVo.put("id", order.getId());
        orderVo.put("orderSn", order.getOrderSn());
        orderVo.put("addTime", order.getAddTime());
        orderVo.put("consignee", order.getConsignee());
        orderVo.put("mobile", order.getMobile());
        orderVo.put("address", order.getAddress());
        orderVo.put("goodsPrice", order.getGoodsPrice());
        orderVo.put("freightPrice", order.getFreightPrice());
        orderVo.put("actualPrice", order.getActualPrice());
        orderVo.put("orderStatusText", OrderUtil.orderStatusText(order));
        orderVo.put("handleOption", OrderUtil.build(order));
        orderVo.put("expCode", order.getShipChannel());
        orderVo.put("expNo", order.getShipSn());

        List<SksOrderGoods> orderGoodsList = orderGoodsService.queryByOid(order.getId());
        List<Map<String, Object>> orderGoodsVoList = new ArrayList<>(orderGoodsList.size());
        for (SksOrderGoods orderGoods : orderGoodsList) {
            Map<String, Object> orderGoodsVo = new HashMap<>();
            orderGoodsVo.put("id", orderGoods.getId());
            orderGoodsVo.put("orderId", orderGoods.getOrderId());
            orderGoodsVo.put("goodsId", orderGoods.getGoodsId());
            orderGoodsVo.put("goodsName", orderGoods.getGoodsName());
            orderGoodsVo.put("number", orderGoods.getNumber());
            orderGoodsVo.put("retailPrice", orderGoods.getPrice());
            orderGoodsVo.put("picUrl", orderGoods.getPicUrl());
            orderGoodsVo.put("goodsSpecificationValues", orderGoods.getSpecifications());
            orderGoodsVoList.add(orderGoodsVo);
        }

        Map<String, Object> result = new HashMap<>();
        result.put("orderInfo", orderVo);
        result.put("orderGoods", orderGoodsVoList);

        // 订单状态为已发货且物流信息不为空
        //"YTO", "800669400640887922"
        if (order.getOrderStatus().equals(OrderUtil.STATUS_SHIP)) {
            ExpressInfo ei = expressService.getExpressInfo(order.getShipChannel(), order.getShipSn());
            result.put("expressInfo", ei);
        }

        UserVo creator = userService.findUserVoById(snapup.getCreatorUserId());
        List<UserVo> joiners = new ArrayList<>();
        joiners.add(creator);
        int linkSnapUpId;
        // 这是一个团购发起记录
        if (snapup.getSnapUpId() == 0) {
            linkSnapUpId = snapup.getId();
        } else {
            linkSnapUpId = snapup.getSnapUpId();

        }
        List<SksSnapUp> snapups = snapupService.queryJoinRecord(linkSnapUpId);

        UserVo joiner;
        for (SksSnapUp snapupItem : snapups) {
            joiner = userService.findUserVoById(snapupItem.getUserId());
            joiners.add(joiner);
        }

        result.put("linkSnapUpId", linkSnapUpId);
        result.put("creator", creator);
        result.put("joiners", joiners);
        result.put("snapup", snapup);
        result.put("rules", rules);
        return ResponseUtil.ok(result);
    }

    /**
     * 参加团购
     *
     * @param snapupId 团购活动ID
     * @return 操作结果
     */
    @GetMapping("join")
    public Object join(@NotNull Integer snapupId) {
        SksSnapUp snapup = snapupService.queryById(snapupId);
        if (snapup == null) {
            return ResponseUtil.badArgumentValue();
        }

        SksSnapUpRules rules = rulesService.findById(snapup.getRulesId());
        if (rules == null) {
            return ResponseUtil.badArgumentValue();
        }

        SksGoods goods = goodsService.findById(rules.getGoodsId());
        if (goods == null) {
            return ResponseUtil.badArgumentValue();
        }

        Map<String, Object> result = new HashMap<>();
        result.put("snapup", snapup);
        result.put("goods", goods);

        return ResponseUtil.ok(result);
    }

    /**
     * 用户开团或入团情况
     *
     * @param userId 用户ID
     * @param showType 显示类型，如果是0，则是当前用户开的团购；否则，则是当前用户参加的团购
     * @return 用户开团或入团情况
     */
    @GetMapping("my")
    public Object my(@LoginUser Integer userId, @RequestParam(defaultValue = "0") Integer showType) {
        if (userId == null) {
            return ResponseUtil.unlogin();
        }

        List<SksSnapUp> mySnapUps;
        if (showType == 0) {
            mySnapUps = snapupService.queryMySnapUp(userId);
        } else {
            mySnapUps = snapupService.queryMyJoinSnapUp(userId);
        }

        List<Map<String, Object>> snapupVoList = new ArrayList<>(mySnapUps.size());

        SksOrder order;
        SksSnapUpRules rules;
        SksUser creator;
        for (SksSnapUp snapup : mySnapUps) {
            order = orderService.findById(userId, snapup.getOrderId());
            rules = rulesService.findById(snapup.getRulesId());
            creator = userService.findById(snapup.getCreatorUserId());

            Map<String, Object> snapupVo = new HashMap<>();
            //填充团购信息
            snapupVo.put("id", snapup.getId());
            snapupVo.put("snapup", snapup);
            snapupVo.put("rules", rules);
            snapupVo.put("creator", creator.getNickname());

            int linkSnapUpId;
            // 这是一个团购发起记录
            if (snapup.getSnapUpId() == 0) {
                linkSnapUpId = snapup.getId();
                snapupVo.put("isCreator", creator.getId() == userId);
            } else {
                linkSnapUpId = snapup.getSnapUpId();
                snapupVo.put("isCreator", false);
            }
            int joinerCount = snapupService.countSnapUp(linkSnapUpId);
            snapupVo.put("joinerCount", joinerCount + 1);

            //填充订单信息
            snapupVo.put("orderId", order.getId());
            snapupVo.put("orderSn", order.getOrderSn());
            snapupVo.put("actualPrice", order.getActualPrice());
            snapupVo.put("orderStatusText", OrderUtil.orderStatusText(order));

            List<SksOrderGoods> orderGoodsList = orderGoodsService.queryByOid(order.getId());
            List<Map<String, Object>> orderGoodsVoList = new ArrayList<>(orderGoodsList.size());
            for (SksOrderGoods orderGoods : orderGoodsList) {
                Map<String, Object> orderGoodsVo = new HashMap<>();
                orderGoodsVo.put("id", orderGoods.getId());
                orderGoodsVo.put("goodsName", orderGoods.getGoodsName());
                orderGoodsVo.put("number", orderGoods.getNumber());
                orderGoodsVo.put("picUrl", orderGoods.getPicUrl());
                orderGoodsVoList.add(orderGoodsVo);
            }
            snapupVo.put("goodsList", orderGoodsVoList);
            snapupVoList.add(snapupVo);
        }

        Map<String, Object> result = new HashMap<>();
        result.put("total", snapupVoList.size());
        result.put("list", snapupVoList);

        return ResponseUtil.ok(result);
    }

}
