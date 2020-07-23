package com.neusoft.bsp.user.controller;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.neusoft.bsp.user.entity.User;
import com.neusoft.bsp.user.service.LoginService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
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
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class LoginControllerTest {
    @Resource
    private MockMvc mockMvc;

    @Resource
    private MockHttpSession mockHttpSession;

    @MockBean
    private LoginService loginService;

    @Resource
    private LoginController loginController;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(loginController).build();
        mockHttpSession.setAttribute("code", "abc");
    }

    @Test
    public void login() throws Exception {
        User user = new User();
        user.setUsername("username");
        user.setPassword("password");

        Map<String, String> params = new HashMap<>();
        params.put("username", "username");
        params.put("password", "password");
        params.put("code", "abc");
        
        when(loginService.login(any(), any())).thenReturn(user);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/user/login")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(JSON.toJSONString(params))
                .session(mockHttpSession)
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print())
                .andReturn();

        Map response = (Map) JSON.parse(mvcResult.getResponse().getContentAsString());
        Assertions.assertEquals(200, response.get("status"));
    }
}
