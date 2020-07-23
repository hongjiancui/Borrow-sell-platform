package com.neusoft.bsp.info.controller;

import com.alibaba.fastjson.JSON;
import com.neusoft.bsp.info.entity.Brand;
import com.neusoft.bsp.info.entity.DropShipper;
import com.neusoft.bsp.info.service.DropShipperService;
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

import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BvoControllerTest {
    @MockBean
    private DropShipperService dropShipperService;

    @Resource
    private BvoController bvoController;

    @Resource
    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(bvoController).build();
    }

    @Test
    public void getBvoInfo() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/info/bvo/get")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .param("userId", "test")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());
    }

    @Test
    public void updateBvoInfo() throws Exception {
        when(dropShipperService.updateDropShipper(any())).thenReturn(1);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/info/bvo/update")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(JSON.toJSONString(new DropShipper()))
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print())
                .andReturn();

        Map response = (Map) JSON.parse(mvcResult.getResponse().getContentAsString());
        Assertions.assertEquals(200, response.get("status"));
    }

    @Test
    public void addBvoInfo() throws Exception {
        when(dropShipperService.addDropShipper(any())).thenReturn(1);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/info/bvo/add")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(JSON.toJSONString(new DropShipper()))
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print())
                .andReturn();

        Map response = (Map) JSON.parse(mvcResult.getResponse().getContentAsString());
        Assertions.assertEquals(200, response.get("status"));
    }
}