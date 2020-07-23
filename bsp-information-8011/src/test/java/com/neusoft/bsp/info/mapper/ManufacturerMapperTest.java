package com.neusoft.bsp.info.mapper;

import com.neusoft.bsp.info.entity.Manufacturer;
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
public class ManufacturerMapperTest {
    @Resource
    private ManufacturerMapper manufacturerMapper;

    @Test
    public void getManufacturersByUserId() {
        String userId = "3";
        List<Manufacturer> result = manufacturerMapper.getManufacturersByUserId(userId);
        Assertions.assertTrue(result.size() > 0);
    }

    @Test
    public void updateImageUrl() {
        String manId = "1";
        String imageUrl = "http://xxxx.com";

        int result = manufacturerMapper.updateImageUrl(manId, imageUrl);
        Assertions.assertEquals(1, result);
    }
}