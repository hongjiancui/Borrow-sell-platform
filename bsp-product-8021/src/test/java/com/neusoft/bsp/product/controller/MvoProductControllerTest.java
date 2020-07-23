package com.neusoft.bsp.product.controller;

import com.alibaba.fastjson.JSON;
import com.neusoft.bsp.product.entity.Product;
import com.neusoft.bsp.product.entity.Wishlist;
import com.neusoft.bsp.product.service.ProductService;
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

import java.util.HashMap;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MvoProductControllerTest {
    @MockBean
    private ProductService productService;

    @Resource
    private MockMvc mockMvc;

    @Resource
    private MvoProductController mvoProductController;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(mvoProductController).build();
    }

    @Test
    public void getAllProduct() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/pro/mvo/product/all")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .param("userId", "test")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());
    }

    @Test
    public void getProductBasic() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/pro/mvo/product/get")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .param("brdId", "test")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());
    }

    @Test
    public void getProductDetail() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/pro/mvo/product/detail/get")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .param("proId", "test")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());
    }

    @Test
    public void addProduct() throws Exception {
        when(productService.addProduct(any())).thenReturn(1);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/pro/mvo/product/add")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(JSON.toJSONString(new HashMap<>()))
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print())
                .andReturn();

        Map response = (Map) JSON.parse(mvcResult.getResponse().getContentAsString());
        Assertions.assertEquals(200, response.get("status"));
    }

    @Test
    public void updateProduct() throws Exception {
        when(productService.updateProduct(any())).thenReturn(1);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/pro/mvo/product/update")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(JSON.toJSONString(new Product()))
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print())
                .andReturn();

        Map response = (Map) JSON.parse(mvcResult.getResponse().getContentAsString());
        Assertions.assertEquals(200, response.get("status"));
    }

    @Test
    public void updateProductStatus() throws Exception {
        when(productService.updateProductStatus(any())).thenReturn(1);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/pro/mvo/product/status/update")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(JSON.toJSONString(new Product()))
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print())
                .andReturn();

        Map response = (Map) JSON.parse(mvcResult.getResponse().getContentAsString());
        Assertions.assertEquals(200, response.get("status"));
    }

    @Test
    public void deleteProduct() throws Exception {
        when(productService.deleteProduct(any())).thenReturn(1);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/pro/mvo/product/delete")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(JSON.toJSONString(new Product()))
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print())
                .andReturn();

        Map response = (Map) JSON.parse(mvcResult.getResponse().getContentAsString());
        Assertions.assertEquals(200, response.get("status"));
    }

    @Test
    public void updateProductDetail() throws Exception {
        when(productService.updateProductDetail(any())).thenReturn(1);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/pro/mvo/product/detail/update")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(JSON.toJSONString(new HashMap<>()))
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print())
                .andReturn();

        Map response = (Map) JSON.parse(mvcResult.getResponse().getContentAsString());
        Assertions.assertEquals(200, response.get("status"));
    }
}