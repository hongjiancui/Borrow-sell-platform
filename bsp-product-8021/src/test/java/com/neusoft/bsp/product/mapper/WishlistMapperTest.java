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

import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
@Transactional
public class WishlistMapperTest {
    @Resource
    private WishlistMapper wishlistMapper;

    @Test
    public void getWishlistByDsrId() {
        String dsrId = "1";
        List<Map<String, String>> result = wishlistMapper.getWishlistByDsrId(dsrId);
        Assertions.assertTrue(result.size() > 0);
    }
}