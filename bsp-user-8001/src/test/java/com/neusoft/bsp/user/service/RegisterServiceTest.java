package com.neusoft.bsp.user.service;

import com.neusoft.bsp.user.entity.User;
import com.neusoft.bsp.user.feign.DropShipperFeignService;
import com.neusoft.bsp.user.feign.WalletFeignService;
import com.neusoft.bsp.user.mapper.PermissionMapper;
import com.neusoft.bsp.user.mapper.RoleMapper;
import com.neusoft.bsp.user.mapper.UserMapper;
import com.neusoft.bsp.user.service.impl.MenuServiceImpl;
import com.neusoft.bsp.user.service.impl.RegisterServiceImpl;
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

@RunWith(SpringRunner.class)
@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
public class RegisterServiceTest {
    @MockBean
    private UserMapper userMapper;

    @MockBean
    private RoleMapper roleMapper;

    @MockBean
    private PermissionMapper permissionMapper;

    @MockBean
    private DropShipperFeignService dropShipperFeignService;

    @MockBean
    private WalletFeignService walletFeignService;

    @Resource
    private RegisterService registerService;

    @Configuration
    static class registerServiceConfig {
        @Bean
        public RegisterService registerService() {
            return new RegisterServiceImpl();
        }
    }

    @Test
    public void getUsername() {
        Mockito.when(userMapper.getUsername("exist"))
                .thenReturn(1);
        Mockito.when(userMapper.getUsername("not exist"))
                .thenReturn(0);

        int exist = registerService.getUsername("exist");
        int not_exist = registerService.getUsername("not exist");
        Assertions.assertEquals(1, exist);
        Assertions.assertEquals(0, not_exist);
    }

    @Test
    public void register() {
        Mockito.when(userMapper.getLastId())
                .thenReturn("1");

        User user = new User();
        user.setWalletId("1");
        user.setRoleId("1");
        registerService.register(user);
    }
}
