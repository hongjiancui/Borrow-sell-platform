package com.neusoft.bsp.user.service;

import com.neusoft.bsp.user.entity.Permission;
import com.neusoft.bsp.user.entity.User;
import com.neusoft.bsp.user.mapper.PermissionMapper;
import com.neusoft.bsp.user.service.impl.LoginServiceImpl;
import com.neusoft.bsp.user.service.impl.MenuServiceImpl;
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
import java.util.*;

@RunWith(SpringRunner.class)
@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
public class MenuServiceTest {
    @MockBean
    private PermissionMapper permissionMapper;

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
        User user = new User();
        Permission permission = new Permission();
        permission.setPermissionId("1");
        permission.setName("test-permission");
        user.setPermissions(Collections.singletonList(permission));

        Mockito.when(permissionMapper.getPermissionsOfUser())
                .thenReturn(Collections.singletonList(user));

        List<User> allMenu = menuService.getAllMenu();
        Assertions.assertTrue(allMenu.size() > 0);
        Assertions.assertEquals("test-permission", allMenu.get(0).getPermissions().get(0).getName());
        Assertions.assertEquals("1", allMenu.get(0).getPermissions().get(0).getPermissionId());
    }

    @Test
    public void addMenu() {
        Map<String, String> params = new HashMap<>();
        params.put("10", "10");
        menuService.addMenu(params);
    }

    @Test
    public void deleteMenu() {
        Map<String, String> params = new HashMap<>();
        params.put("10", "10");
        menuService.deleteMenu(params);
    }
}
