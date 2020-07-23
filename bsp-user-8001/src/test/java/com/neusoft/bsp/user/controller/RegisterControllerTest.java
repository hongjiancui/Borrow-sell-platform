package com.neusoft.bsp.user.controller;

import com.alibaba.fastjson.JSON;
import com.neusoft.bsp.user.entity.User;
import com.neusoft.bsp.user.service.RegisterService;
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

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RegisterControllerTest {
    @Resource
    private MockMvc mockMvc;

    @MockBean
    private RegisterService registerService;

    @Resource
    private RegisterController registerController;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(registerController).build();
    }

    @Test
    public void usernameExist() throws Exception {
        when(registerService.getUsername("admin")).thenReturn(1);
        when(registerService.getUsername("abcd")).thenReturn(0);

        MvcResult mvcResult_exist = mockMvc.perform(MockMvcRequestBuilders.get("/user/username/exist")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .param("username", "admin")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        MvcResult mvcResult_notExist = mockMvc.perform(MockMvcRequestBuilders.get("/user/username/exist")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .param("username", "abcd")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        Map response_exist = (Map) JSON.parse(mvcResult_exist.getResponse().getContentAsString());
        Map response_notExist = (Map) JSON.parse(mvcResult_notExist.getResponse().getContentAsString());

        Assertions.assertTrue(response_exist.get("data").toString().contains("1"));
        Assertions.assertTrue(response_notExist.get("data").toString().contains("0"));
    }

    @Test
    public void register() throws Exception {
        User user = new User();
        user.setUsername("username");
        user.setPassword("password");

        mockMvc.perform(MockMvcRequestBuilders.post("/user/register")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(JSON.toJSONString(user))
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
