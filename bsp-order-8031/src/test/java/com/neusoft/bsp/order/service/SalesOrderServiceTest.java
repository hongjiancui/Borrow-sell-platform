package com.neusoft.bsp.order.service;

import com.neusoft.bsp.order.entity.DropShipper;
import com.neusoft.bsp.order.entity.Product;
import com.neusoft.bsp.order.entity.SalesOrder;
import com.neusoft.bsp.order.feign.InfoFeignService;
import com.neusoft.bsp.order.feign.ProductFeignService;
import com.neusoft.bsp.order.feign.WalletFeignService;
import com.neusoft.bsp.order.mapper.SalesOrderMapper;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
public class SalesOrderServiceTest {
    @MockBean
    private SalesOrderMapper salesOrderMapper;

    @MockBean
    private ProductFeignService productFeignService;

    @MockBean
    private InfoFeignService infoFeignService;

    @MockBean
    private WalletFeignService walletFeignService;

    @Resource
    private SalesOrderService salesOrderService;

    @Configuration
    static class salesOrderServiceConfig {
        @Bean
        public SalesOrderService salesOrderService() {
            return new SalesOrderServiceImpl();
        }
    }

    @Test
    public void getOrders() {
        String operation = "0";
        String id = "1";

        List<SalesOrder> result = new ArrayList<>();
        result.add(new SalesOrder());

        when(salesOrderMapper.getOrdersByBrdId(any())).thenReturn(result);

        List<SalesOrder> returnData = salesOrderService.getOrders(operation, id);
        Assertions.assertTrue(returnData.size() > 0);
    }

    @Test
    public void getOrderDetail() {
        String saoId = "0";
        SalesOrder salesOrder = new SalesOrder();
        salesOrder.setSaoId(saoId);

        when(salesOrderMapper.getDetail(any())).thenReturn(salesOrder);

        SalesOrder result = salesOrderService.getOrderDetail(saoId);
        Assertions.assertEquals(saoId, result.getSaoId());
    }

    @Test
    public void ship() {
        when(salesOrderMapper.ship(any())).thenReturn(1);

        String saoId = "1";

        int result = salesOrderService.ship(saoId);
        Assertions.assertEquals(1, result);
    }

    @Test
    public void cancel() {
        String saoId = "1";

        SalesOrder salesOrder = new SalesOrder();
        salesOrder.setDsrId("1");
        salesOrder.setBrdId("1");
        salesOrder.setPrice("100");
        salesOrder.setProductAmount("1");
        when(salesOrderMapper.getById(any())).thenReturn(salesOrder);

        DropShipper dropShipper = new DropShipper();
        dropShipper.setUserId("1");
        when(infoFeignService.getDropShipperByDsrId(any())).thenReturn(dropShipper);
        when(infoFeignService.getBrandUserId(any())).thenReturn("1");

        salesOrderService.cancel(saoId);
    }

    @Test
    public void pay() {
        Map<String, String> params = new HashMap<>();
        params.put("saoId", "1");
        params.put("walletId", "1");

        SalesOrder salesOrder = new SalesOrder();
        salesOrder.setDsrId("1");
        salesOrder.setBrdId("1");
        salesOrder.setPrice("100");
        salesOrder.setProductAmount("1");
        when(salesOrderMapper.getById(any())).thenReturn(salesOrder);
        when(infoFeignService.getBrandUserId(any())).thenReturn("1");

        salesOrderService.pay(params);
    }

    @Test
    public void buy() {
        SalesOrder salesOrder = new SalesOrder();
        salesOrder.setProId("1");
        when(salesOrderMapper.insert(any())).thenReturn(1);

        Product product = new Product();
        product.setBrdId("1");
        product.setMinRetailPrice("100");
        when(productFeignService.getProduct(any())).thenReturn(product);

        int result = salesOrderService.buy(salesOrder);
        Assertions.assertEquals(1, result);
    }
}