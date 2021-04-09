package com.angeleo.sks.core.system;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * 系统设置
 */
public class SystemConfig {
    // 小程序相关配置
    public final static String SKS_WX_INDEX_NEW = "sks_wx_index_new";
    public final static String SKS_WX_INDEX_HOT = "sks_wx_index_hot";
    public final static String SKS_WX_INDEX_BRAND = "sks_wx_index_brand";
    public final static String SKS_WX_INDEX_TOPIC = "sks_wx_index_topic";
    public final static String SKS_WX_INDEX_CATLOG_LIST = "sks_wx_catlog_list";
    public final static String SKS_WX_INDEX_CATLOG_GOODS = "sks_wx_catlog_goods";
    public final static String SKS_WX_SHARE = "sks_wx_share";
    // 运费相关配置
    public final static String SKS_EXPRESS_FREIGHT_VALUE = "sks_express_freight_value";
    public final static String SKS_EXPRESS_FREIGHT_MIN = "sks_express_freight_min";
    // 订单相关配置
    public final static String SKS_ORDER_UNPAID = "sks_order_unpaid";
    public final static String SKS_ORDER_UNCONFIRM = "sks_order_unconfirm";
    public final static String SKS_ORDER_COMMENT = "sks_order_comment";
    // 商场相关配置
    public final static String SKS_MALL_NAME = "sks_mall_name";
    public final static String SKS_MALL_ADDRESS = "sks_mall_address";
    public final static String SKS_MALL_PHONE = "sks_mall_phone";
    public final static String SKS_MALL_QQ = "sks_mall_qq";
    public final static String SKS_MALL_LONGITUDE = "sks_mall_longitude";
    public final static String SKS_MALL_Latitude = "sks_mall_latitude";

    //所有的配置均保存在该 HashMap 中
    private static Map<String, String> SYSTEM_CONFIGS = new HashMap<>();

    private static String getConfig(String keyName) {
        return SYSTEM_CONFIGS.get(keyName);
    }

    private static Integer getConfigInt(String keyName) {
        return Integer.parseInt(SYSTEM_CONFIGS.get(keyName));
    }

    private static Boolean getConfigBoolean(String keyName) {
        return Boolean.valueOf(SYSTEM_CONFIGS.get(keyName));
    }

    private static BigDecimal getConfigBigDec(String keyName) {
        return new BigDecimal(SYSTEM_CONFIGS.get(keyName));
    }

    public static Integer getNewLimit() {
        return getConfigInt(SKS_WX_INDEX_NEW);
    }

    public static Integer getHotLimit() {
        return getConfigInt(SKS_WX_INDEX_HOT);
    }

    public static Integer getBrandLimit() {
        return getConfigInt(SKS_WX_INDEX_BRAND);
    }

    public static Integer getTopicLimit() {
        return getConfigInt(SKS_WX_INDEX_TOPIC);
    }

    public static Integer getCatlogListLimit() {
        return getConfigInt(SKS_WX_INDEX_CATLOG_LIST);
    }

    public static Integer getCatlogMoreLimit() {
        return getConfigInt(SKS_WX_INDEX_CATLOG_GOODS);
    }

    public static boolean isAutoCreateShareImage() {
        return getConfigBoolean(SKS_WX_SHARE);
    }

    public static BigDecimal getFreight() {
        return getConfigBigDec(SKS_EXPRESS_FREIGHT_VALUE);
    }

    public static BigDecimal getFreightLimit() {
        return getConfigBigDec(SKS_EXPRESS_FREIGHT_MIN);
    }

    public static Integer getOrderUnpaid() {
        return getConfigInt(SKS_ORDER_UNPAID);
    }

    public static Integer getOrderUnconfirm() {
        return getConfigInt(SKS_ORDER_UNCONFIRM);
    }

    public static Integer getOrderComment() {
        return getConfigInt(SKS_ORDER_COMMENT);
    }

    public static String getMallName() {
        return getConfig(SKS_MALL_NAME);
    }

    public static String getMallAddress() {
        return getConfig(SKS_MALL_ADDRESS);
    }

    public static String getMallPhone() {
        return getConfig(SKS_MALL_PHONE);
    }

    public static String getMallQQ() {
        return getConfig(SKS_MALL_QQ);
    }

    public static String getMallLongitude() {
        return getConfig(SKS_MALL_LONGITUDE);
    }

    public static String getMallLatitude() {
        return getConfig(SKS_MALL_Latitude);
    }

    public static void setConfigs(Map<String, String> configs) {
        SYSTEM_CONFIGS = configs;
    }

    public static void updateConfigs(Map<String, String> data) {
        for (Map.Entry<String, String> entry : data.entrySet()) {
            SYSTEM_CONFIGS.put(entry.getKey(), entry.getValue());
        }
    }
}