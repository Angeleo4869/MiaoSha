package com.angeleo.sks.wx.task;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.angeleo.sks.wx.service.WxOrderService;
import com.angeleo.sks.core.system.SystemConfig;
import com.angeleo.sks.core.task.Task;
import com.angeleo.sks.core.util.BeanUtil;
import com.angeleo.sks.db.pojo.SksOrder;
import com.angeleo.sks.db.pojo.SksOrderGoods;
import com.angeleo.sks.db.service.SksGoodsProductService;
import com.angeleo.sks.db.service.SksOrderGoodsService;
import com.angeleo.sks.db.service.SksOrderService;
import com.angeleo.sks.db.util.OrderUtil;

import java.time.LocalDateTime;
import java.util.List;

public class OrderUnpaidTask extends Task {
    private final Log logger = LogFactory.getLog(OrderUnpaidTask.class);
    private int orderId = -1;

    public OrderUnpaidTask(Integer orderId, long delayInMilliseconds){
        super("OrderUnpaidTask-" + orderId, delayInMilliseconds);
        this.orderId = orderId;
    }

    public OrderUnpaidTask(Integer orderId){
        super("OrderUnpaidTask-" + orderId, SystemConfig.getOrderUnpaid() * 60 * 1000);
        this.orderId = orderId;
    }

    @Override
    public void run() {
        logger.info("系统开始处理延时任务---订单超时未付款---" + this.orderId);

        SksOrderService orderService = BeanUtil.getBean(SksOrderService.class);
        SksOrderGoodsService orderGoodsService = BeanUtil.getBean(SksOrderGoodsService.class);
        SksGoodsProductService productService = BeanUtil.getBean(SksGoodsProductService.class);
        WxOrderService wxOrderService = BeanUtil.getBean(WxOrderService.class);

        SksOrder order = orderService.findById(this.orderId);
        if(order == null){
            return;
        }
        if(!OrderUtil.isCreateStatus(order)){
            return;
        }

        // 设置订单已取消状态
        order.setOrderStatus(OrderUtil.STATUS_AUTO_CANCEL);
        order.setEndTime(LocalDateTime.now());
        if (orderService.updateWithOptimisticLocker(order) == 0) {
            throw new RuntimeException("更新数据已失效");
        }

        // 商品货品数量增加
        Integer orderId = order.getId();
        List<SksOrderGoods> orderGoodsList = orderGoodsService.queryByOid(orderId);
        for (SksOrderGoods orderGoods : orderGoodsList) {
            Integer productId = orderGoods.getProductId();
            Short number = orderGoods.getNumber();
            if (productService.addStock(productId, number) == 0) {
                throw new RuntimeException("商品货品库存增加失败");
            }
        }

        //返还优惠券
        wxOrderService.releaseCoupon(orderId);

        logger.info("系统结束处理延时任务---订单超时未付款---" + this.orderId);
    }
}
