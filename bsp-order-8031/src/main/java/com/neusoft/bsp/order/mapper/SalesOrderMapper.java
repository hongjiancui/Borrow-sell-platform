package com.neusoft.bsp.order.mapper;

import com.neusoft.bsp.common.base.BaseMapper;
import com.neusoft.bsp.order.entity.SalesOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SalesOrderMapper extends BaseMapper<String, SalesOrder> {
    List<SalesOrder> getOrdersByBrdId(@Param("brdId") String brdId);

    List<SalesOrder> getOrdersByDsrId(@Param("dsrId") String dsrId);

    SalesOrder getDetail(@Param("saoId") String saoId);

    int ship(@Param("saoId") String saoId);

    int cancel(@Param("saoId") String saoId);

    int pay(@Param("saoId") String saoId);
}
