package com.neusoft.bsp.user.service;

import com.neusoft.bsp.user.entity.User;

public interface LoginService {
    User login(String username, String password);
}
