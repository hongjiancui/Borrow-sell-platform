package com.neusoft.bsp.user.controller;


import com.neusoft.bsp.user.entity.User;
import com.neusoft.bsp.user.service.MenuService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserFeignController {
    @Resource
    private MenuService menuService;

    @RequestMapping(value = "/menu/all", method = RequestMethod.GET)
    public List<User> getAllMenu() {
        return menuService.getAllMenu();
    }

    @RequestMapping(value = "/menu/add", method = RequestMethod.POST)
    public void addMenu(@RequestBody Map<String, String> params) {
        menuService.addMenu(params);
    }

    @RequestMapping(value = "/menu/delete", method = RequestMethod.POST)
    public void deleteMenu(@RequestBody Map<String, String> params) {
        menuService.deleteMenu(params);
    }
}
