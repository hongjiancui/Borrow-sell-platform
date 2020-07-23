package com.neusoft.bsp.info.mapper;

import com.neusoft.bsp.info.entity.DropShipper;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
@Transactional
public class DropShipperMapperTest {
    @Resource
    private DropShipperMapper dropShipperMapper;

    @Test
    public void getDropShipperByUserId() {
        String userId = "7";
        DropShipper result = dropShipperMapper.getDropShipperByUserId(userId);
        Assertions.assertEquals(userId, result.getUserId());
    }
}