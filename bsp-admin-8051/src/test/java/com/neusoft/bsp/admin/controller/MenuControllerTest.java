package com.neusoft.bsp.admin.controller;

import com.alibaba.fastjson.JSON;
import com.neusoft.bsp.admin.service.MenuService;
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

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MenuControllerTest {
    @MockBean
    private MenuService menuService;

    @Resource
    private MenuController menuController;

    @Resource
    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(menuController).build();
    }

    @Test
    public void getAllMenu() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/admin/menu/get")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());
    }

    @Test
    public void addMenu() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/admin/menu/add")
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
    public void deleteMenu() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/admin/menu/delete")
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