package com.neusoft.bsp.user.service;

import com.neusoft.bsp.user.entity.User;

public interface RegisterService {
    int getUsername(String username);

    void register(User user);
}
