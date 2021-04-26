package com.angeleo.sks.admin.task;

import com.angeleo.sks.db.pojo.SksSnapUp;
import com.angeleo.sks.db.pojo.SksSnapUpRules;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.angeleo.sks.db.service.SksSnapUpRulesService;
import com.angeleo.sks.db.service.SksSnapUpService;
import com.angeleo.sks.db.service.SksOrderService;
import com.angeleo.sks.core.task.Task;
import com.angeleo.sks.core.util.BeanUtil;
import com.angeleo.sks.db.pojo.SksOrder;
import com.angeleo.sks.db.util.SnapUpConstant;
import com.angeleo.sks.db.util.OrderUtil;

import java.util.List;

public class SnapUpRuleExpiredTask extends Task {
    private final Log logger = LogFactory.getLog(SnapUpRuleExpiredTask.class);
    private int grouponRuleId = -1;

    public SnapUpRuleExpiredTask(Integer grouponRuleId, long delayInMilliseconds){
        super("SnapUpRuleExpiredTask-" + grouponRuleId, delayInMilliseconds);
        this.grouponRuleId = grouponRuleId;
    }

    @Override
    public void run() {
        logger.info("系统开始处理延时任务---秒杀规则过期---" + this.grouponRuleId);

        SksOrderService orderService = BeanUtil.getBean(SksOrderService.class);
        SksSnapUpService grouponService = BeanUtil.getBean(SksSnapUpService.class);
        SksSnapUpRulesService grouponRulesService = BeanUtil.getBean(SksSnapUpRulesService.class);

        SksSnapUpRules grouponRules = grouponRulesService.findById(grouponRuleId);
        if(grouponRules == null){
            return;
        }
        if(!grouponRules.getStatus().equals(SnapUpConstant.RULE_STATUS_ON)){
            return;
        }

        // 秒杀活动取消
        grouponRules.setStatus(SnapUpConstant.RULE_STATUS_DOWN_EXPIRE);
        grouponRulesService.updateById(grouponRules);

        List<SksSnapUp> grouponList = grouponService.queryByRuleId(grouponRuleId);
        // 用户秒杀处理
        for(SksSnapUp groupon : grouponList){
            Short status = groupon.getStatus();
            SksOrder order = orderService.findById(groupon.getOrderId());
            if(status.equals(SnapUpConstant.STATUS_NONE)){
                groupon.setStatus(SnapUpConstant.STATUS_FAIL);
                grouponService.updateById(groupon);
            }
            else if(status.equals(SnapUpConstant.STATUS_ON)){
                // 如果秒杀进行中
                // (1) 秒杀设置秒杀失败等待退款状态
                groupon.setStatus(SnapUpConstant.STATUS_FAIL);
                grouponService.updateById(groupon);
                // (2) 秒杀订单申请退款
                if(OrderUtil.isPayStatus(order)) {
                    order.setOrderStatus(OrderUtil.STATUS_REFUND);
                    orderService.updateWithOptimisticLocker(order);
                }
            }
        }
        logger.info("系统结束处理延时任务---秒杀规则过期---" + this.grouponRuleId);
    }
}
