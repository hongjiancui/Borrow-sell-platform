package com.neusoft.bsp.order.service.impl;

import com.neusoft.bsp.order.entity.Order;
import com.neusoft.bsp.order.entity.Product;
import com.neusoft.bsp.order.feign.ProductFeignService;
import com.neusoft.bsp.order.mapper.OrderMapper;
import com.neusoft.bsp.order.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderMapper orderMapper;

    @Resource
    private ProductFeignService productFeignService;

    @Override
    public int sell(Order order) {
        //调用product服务获取产品信息
        Product product = productFeignService.getProduct(order.getProId());
        order.setName(product.getName());

        return orderMapper.insert(order);
    }

    @Override
    public List<Order> getSellOrder(String strId) {
        return orderMapper.getSellOrder(strId);
    }

    @Override
    public int deleteSellOrder(String bsoId) {
        return orderMapper.delete(bsoId);
    }
}
