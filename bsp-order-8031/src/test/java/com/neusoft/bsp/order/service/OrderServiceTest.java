package com.neusoft.bsp.order.service;

import com.neusoft.bsp.order.entity.Order;
import com.neusoft.bsp.order.entity.Product;
import com.neusoft.bsp.order.feign.ProductFeignService;
import com.neusoft.bsp.order.mapper.OrderMapper;
import com.neusoft.bsp.order.service.impl.OrderServiceImpl;
import com.neusoft.bsp.order.service.impl.SalesOrderServiceImpl;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
public class OrderServiceTest {
    @MockBean
    private OrderMapper orderMapper;

    @MockBean
    private ProductFeignService productFeignService;

    @Resource
    private OrderService orderService;

    @Configuration
    static class orderServiceConfig {
        @Bean
        public OrderService orderService() {
            return new OrderServiceImpl();
        }
    }

    @Test
    public void sell() {
        Order order = new Order();
        order.setProId("1");

        Product product = new Product();
        product.setName("test");
        when(productFeignService.getProduct(any())).thenReturn(product);

        when(orderMapper.insert(any())).thenReturn(1);

        int result = orderService.sell(order);
        Assertions.assertEquals(1, result);
    }

    @Test
    public void getSellOrder() {
        String strId = "1";

        List<Order> result = new ArrayList<>();
        result.add(new Order());
        result.add(new Order());
        when(orderMapper.getSellOrder(any())).thenReturn(result);

        List<Order> sellOrder = orderService.getSellOrder(strId);
        Assertions.assertTrue(sellOrder.size() > 0);
    }

    @Test
    public void deleteSellOrder() {
        String bsoId = "1";
        when(orderMapper.delete(any())).thenReturn(1);

        int result = orderService.deleteSellOrder(bsoId);
        Assertions.assertEquals(1, result);
    }
}