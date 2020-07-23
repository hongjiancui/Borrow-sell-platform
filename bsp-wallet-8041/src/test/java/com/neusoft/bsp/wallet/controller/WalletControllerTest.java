package com.neusoft.bsp.wallet.controller;

import com.alibaba.fastjson.JSON;
import com.neusoft.bsp.wallet.entity.Account;
import com.neusoft.bsp.wallet.entity.AccountFund;
import com.neusoft.bsp.wallet.service.WalletService;
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
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WalletControllerTest {
    @MockBean
    private WalletService walletService;

    @Resource
    private MockMvc mockMvc;

    @Resource
    private WalletController walletController;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(walletController).build();
    }

    @Test
    public void register() throws Exception {
        when(walletService.usernameExist("exist")).thenReturn(1);
        when(walletService.usernameExist("test")).thenReturn(0);
        when(walletService.register(any())).thenReturn(1);

        Account account_exist = new Account();
        Account account_notExist = new Account();
        account_exist.setUsername("exist");
        account_notExist.setUsername("test");

        MvcResult mvcResult_exist = mockMvc.perform(MockMvcRequestBuilders.post("/wallet/register")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(JSON.toJSONString(account_exist))
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andReturn();

        MvcResult mvcResult_notExist = mockMvc.perform(MockMvcRequestBuilders.post("/wallet/register")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(JSON.toJSONString(account_notExist))
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andReturn();

        Map response_exist = (Map) JSON.parse(mvcResult_exist.getResponse().getContentAsString());
        Map response_notExist = (Map) JSON.parse(mvcResult_notExist.getResponse().getContentAsString());

        Assertions.assertEquals("username has been used!", response_exist.get("msg"));
        Assertions.assertEquals(200, response_notExist.get("status"));
    }

    @Test
    public void login() throws Exception {
        when(walletService.login(any())).thenReturn(new Account());

        mockMvc.perform(MockMvcRequestBuilders.post("/wallet/login")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(JSON.toJSONString(new Account()))
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());
    }

    @Test
    public void getWalletInfo() throws Exception {
        when(walletService.getWalletInfo(any())).thenReturn(new AccountFund());

        mockMvc.perform(MockMvcRequestBuilders.get("/wallet/info/get")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .param("walletId", "1")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());
    }

    @Test
    public void updateWallet() throws Exception {
        when(walletService.updateWallet(any())).thenReturn(1);

        mockMvc.perform(MockMvcRequestBuilders.post("/wallet/info/update")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(JSON.toJSONString(new Account()))
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());
    }

    @Test
    public void getTransactions() throws Exception {
        when(walletService.getTransactions(any())).thenReturn(new ArrayList<>());

        mockMvc.perform(MockMvcRequestBuilders.get("/wallet/transaction")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .param("walletId", "1")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());
    }

    @Test
    public void recharge() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/wallet/recharge")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(JSON.toJSONString(new HashMap<>()))
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());
    }

    @Test
    public void withdraw() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/wallet/withdraw")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(JSON.toJSONString(new HashMap<>()))
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());
    }
}