package com.neusoft.bsp.order.service;

import com.neusoft.bsp.order.entity.SalesOrder;

import java.util.List;
import java.util.Map;

public interface SalesOrderService {
    List<SalesOrder> getOrders(String operation, String id);

    SalesOrder getOrderDetail(String saoId);

    int ship(String saoId);

    void cancel(String saoId);

    void pay(Map<String, String> params);

    int buy(SalesOrder salesOrder);
}
