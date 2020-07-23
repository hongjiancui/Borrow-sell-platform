package com.neusoft.bsp.product.service;

import com.neusoft.bsp.product.entity.Wishlist;
import com.neusoft.bsp.product.mapper.WishlistMapper;
import com.neusoft.bsp.product.service.impl.ProductServiceImpl;
import com.neusoft.bsp.product.service.impl.WishlistServiceImpl;
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
public class WishlistServiceTest {
    @MockBean
    private WishlistMapper wishlistMapper;

    @Resource
    private WishlistService wishlistService;

    @Configuration
    static class wishlistServiceConfig {
        @Bean
        public WishlistService wishlistService() {
            return new WishlistServiceImpl();
        }
    }

    @Test
    public void addWishlist() {
        when(wishlistMapper.insert(any())).thenReturn(1);
        int result = wishlistService.addWishlist(new Wishlist());
        Assertions.assertEquals(1, result);
    }

    @Test
    public void deleteWishlist() {
        String witId = "1";
        when(wishlistMapper.delete(any())).thenReturn(1);
        int result = wishlistService.deleteWishlist(witId);
        Assertions.assertEquals(1, result);
    }

    @Test
    public void getDsrWishlist() {
        String dsrId = "1";

        List<Map<String, String>> result = new ArrayList<>();
        result.add(new HashMap<>());
        result.add(new HashMap<>());

        when(wishlistMapper.getWishlistByDsrId(any())).thenReturn(result);
        List<Map<String, String>> returnData = wishlistService.getDsrWishlist(dsrId);
        Assertions.assertTrue(returnData.size() > 0);
    }
}