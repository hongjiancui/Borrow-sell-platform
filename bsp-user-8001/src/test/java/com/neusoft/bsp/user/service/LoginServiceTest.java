package com.neusoft.bsp.user.service;

import com.neusoft.bsp.user.entity.User;
import com.neusoft.bsp.user.mapper.UserMapper;
import com.neusoft.bsp.user.service.impl.LoginServiceImpl;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.mockito.ArgumentMatchers.any;

@RunWith(SpringRunner.class)
@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
public class LoginServiceTest {
    @MockBean
    private UserMapper userMapper;

    @Resource
    private LoginService loginService;

    @Configuration
    static class loginServiceConfig {
        @Bean
        public LoginService loginService() {
            return new LoginServiceImpl();
        }
    }

    @Test
    public void login() {
        User user = new User();
        user.setUsername("test");
        user.setPassword("password");

        Mockito.when(userMapper.getUserByUsername(any()))
                .thenReturn(user);

        User result = loginService.login("test", "password");
        Assertions.assertEquals(user.getUsername(), result.getUsername());
        Assertions.assertEquals(user.getPassword(), result.getPassword());
    }
}
