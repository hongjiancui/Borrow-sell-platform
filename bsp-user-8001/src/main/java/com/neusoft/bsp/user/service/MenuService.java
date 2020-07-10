package com.neusoft.bsp.user.service;

import com.neusoft.bsp.user.entity.User;

import java.util.List;
import java.util.Map;

public interface MenuService {
    List<User> getAllMenu();

    void addMenu(Map<String, String> params);

    void deleteMenu(Map<String, String> params);
}
