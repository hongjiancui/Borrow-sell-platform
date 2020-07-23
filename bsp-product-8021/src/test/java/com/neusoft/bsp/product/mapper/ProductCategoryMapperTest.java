package com.neusoft.bsp.product.mapper;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
@Transactional
public class ProductCategoryMapperTest {
    @Resource
    private ProductCategoryMapper productCategoryMapper;

    @Test
    public void addProductCategory() {
        Map<String, String> params = new HashMap<>();
        params.put("proId", "1");
        params.put("categoryName", "1");

        int result = productCategoryMapper.addProductCategory(params);
        Assertions.assertEquals(1, result);
    }
}