package com.neusoft.bsp.admin.service;

import com.neusoft.bsp.admin.entity.User;
import com.neusoft.bsp.admin.feign.UserFeignService;
import com.neusoft.bsp.admin.service.impl.MenuServiceImpl;
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

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
public class MenuServiceTest {
    @MockBean
    private UserFeignService userFeignService;

    @Resource
    private MenuService menuService;

    @Configuration
    static class menuServiceConfig {
        @Bean
        public MenuService menuService() {
            return new MenuServiceImpl();
        }
    }

    @Test
    public void getAllMenu() {
        List<User> result = new ArrayList<>();
        result.add(new User());
        result.add(new User());

        when(userFeignService.getAllMenu()).thenReturn(result);

        List<User> returnData = menuService.getAllMenu();
        Assertions.assertTrue(returnData.size() > 0);
    }

    @Test
    public void addMenu() {
        Map<String, String> params = new HashMap<>();
        menuService.addMenu(params);
    }

    @Test
    public void deleteMenu() {
        Map<String, String> params = new HashMap<>();
        menuService.deleteMenu(params);
    }
}