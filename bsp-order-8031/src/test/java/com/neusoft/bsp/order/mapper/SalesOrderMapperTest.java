package com.neusoft.bsp.order.mapper;

import com.neusoft.bsp.order.entity.SalesOrder;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
@Transactional
public class SalesOrderMapperTest {
    @Resource
    private SalesOrderMapper salesOrderMapper;

    @Test
    public void getOrdersByBrdId() {
        String brdId = "1";
        List<SalesOrder> salesOrder = salesOrderMapper.getOrdersByBrdId(brdId);
        Assertions.assertTrue(salesOrder.size() > 0);
    }

    @Test
    public void getOrdersByDsrId() {
        String dsrId = "1";
        List<SalesOrder> salesOrder = salesOrderMapper.getOrdersByDsrId(dsrId);
        Assertions.assertTrue(salesOrder.size() > 0);
    }

    @Test
    public void getDetail() {
        String saoId = "1";
        SalesOrder salesOrder = salesOrderMapper.getDetail(saoId);
        Assertions.assertNotNull(salesOrder);
    }

    @Test
    public void ship() {
        String saoId = "1";
        int result = salesOrderMapper.ship(saoId);
        Assertions.assertEquals(1, result);
    }

    @Test
    public void cancel() {
        String saoId = "1";
        int result = salesOrderMapper.cancel(saoId);
        Assertions.assertEquals(1, result);
    }

    @Test
    public void pay() {
        String saoId = "1";
        int result = salesOrderMapper.pay(saoId);
        Assertions.assertEquals(1, result);
    }
}