package com.neusoft.bsp.product.controller;

import com.alibaba.fastjson.JSON;
import com.neusoft.bsp.product.entity.Wishlist;
import com.neusoft.bsp.product.service.ProductService;
import com.neusoft.bsp.product.service.WishlistService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BvoProductControllerTest {
    @MockBean
    private ProductService productService;

    @MockBean
    private WishlistService wishlistService;

    @Resource
    private MockMvc mockMvc;

    @Resource
    private BvoProductController bvoProductController;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(bvoProductController).build();
    }

    @Test
    public void getProductsBS() throws Exception {
        List<Map<String, String>> result = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        map.put("test", "test");
        result.add(map);

        when(productService.getProductsBS()).thenReturn(result);

        mockMvc.perform(MockMvcRequestBuilders.get("/pro/bvo/product/get")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());
    }

    @Test
    public void getProductDetail() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/pro/bvo/product/detail")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .param("proId", "test")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());
    }

    @Test
    public void addWishlist() throws Exception {
        when(wishlistService.addWishlist(any())).thenReturn(1);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/pro/bvo/wishlist/add")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(JSON.toJSONString(new Wishlist()))
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print())
                .andReturn();

        Map response = (Map) JSON.parse(mvcResult.getResponse().getContentAsString());
        Assertions.assertEquals(200, response.get("status"));
    }

    @Test
    public void deleteWishlist() throws Exception {
        when(wishlistService.deleteWishlist(any())).thenReturn(1);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/pro/bvo/wishlist/delete")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(JSON.toJSONString(new Wishlist()))
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print())
                .andReturn();

        Map response = (Map) JSON.parse(mvcResult.getResponse().getContentAsString());
        Assertions.assertEquals(200, response.get("status"));
    }

    @Test
    public void getWishlist() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/pro/bvo/wishlist/get")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .param("dsrId", "test")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());
    }
}