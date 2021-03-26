package com.angeleo.sks.db.mapper;

import com.angeleo.sks.db.pojo.SksOrder;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;

public interface OrderMapper {
    int updateWithOptimisticLocker(@Param("lastUpdateTime") LocalDateTime lastUpdateTime, @Param("order") SksOrder order);
}