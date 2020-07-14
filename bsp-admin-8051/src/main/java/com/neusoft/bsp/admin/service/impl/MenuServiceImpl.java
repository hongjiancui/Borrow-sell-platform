package com.neusoft.bsp.admin.service.impl;

import com.neusoft.bsp.admin.entity.User;
import com.neusoft.bsp.admin.feign.UserFeignService;
import com.neusoft.bsp.admin.service.MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class MenuServiceImpl implements MenuService {
    @Resource
    private UserFeignService userFeignService;

    @Override
    public List<User> getAllMenu() {
        return userFeignService.getAllMenu();
    }

    @Override
    public void addMenu(Map<String, String> params) {
        userFeignService.addMenu(params);
    }

    @Override
    public void deleteMenu(Map<String, String> params) {
        userFeignService.deleteMenu(params);
    }
}
