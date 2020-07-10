package com.neusoft.bsp.order.mapper;

import com.neusoft.bsp.common.base.BaseMapper;
import com.neusoft.bsp.order.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderMapper extends BaseMapper<String, Order> {
    List<Order> getSellOrder(@Param("strId") String strId);
}
