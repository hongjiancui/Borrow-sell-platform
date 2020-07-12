package com.neusoft.bsp.user.controller;


import com.neusoft.bsp.user.entity.User;
import com.neusoft.bsp.user.mapper.UserMapper;
import com.neusoft.bsp.user.service.MenuService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserFeignController {
    @Resource
    private MenuService menuService;

    @Resource
    private UserMapper userMapper;

    @RequestMapping(value = "/menu/all", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('admin')")
    public List<User> getAllMenu() {
        return menuService.getAllMenu();
    }

    @RequestMapping(value = "/menu/add", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('admin')")
    public void addMenu(@RequestBody Map<String, String> params) {
        menuService.addMenu(params);
    }

    @RequestMapping(value = "/menu/delete", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('admin')")
    public void deleteMenu(@RequestBody Map<String, String> params) {
        menuService.deleteMenu(params);
    }

    @RequestMapping(value = "/getUserByUsername", method = RequestMethod.GET)
    @PreAuthorize("isAnonymous()")
    public User getUserByUsername(@RequestParam("username") String username) {
        return userMapper.getUserByUsername(username);
    }
}
