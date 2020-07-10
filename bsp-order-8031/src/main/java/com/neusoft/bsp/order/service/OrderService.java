package com.neusoft.bsp.order.service;

import com.neusoft.bsp.order.entity.Order;

import java.util.List;

public interface OrderService {
    int sell(Order order);

    List<Order> getSellOrder(String strId);

    int deleteSellOrder(String bsoId);
}
