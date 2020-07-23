package com.neusoft.bsp.order.mapper;

import com.neusoft.bsp.order.entity.Order;
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

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
@Transactional
public class OrderMapperTest {
    @Resource
    private OrderMapper orderMapper;

    @Test
    public void getSellOrder() {
        String strId = "1";
        List<Order> result = orderMapper.getSellOrder(strId);

        Assertions.assertTrue(result.size() > 0);
    }
}