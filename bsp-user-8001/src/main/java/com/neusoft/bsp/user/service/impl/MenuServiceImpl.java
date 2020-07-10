package com.neusoft.bsp.user.service.impl;

import com.neusoft.bsp.user.entity.User;
import com.neusoft.bsp.user.mapper.PermissionMapper;
import com.neusoft.bsp.user.service.MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class MenuServiceImpl implements MenuService {
    @Resource
    private PermissionMapper permissionMapper;

    @Override
    public List<User> getAllMenu() {
        return permissionMapper.getPermissionsOfUser();
    }

    @Override
    public void addMenu(Map<String, String> params) {
        String userId = params.get("userId");
        String permissionId = params.get("permissionId");

        permissionMapper.addPermissionForUser(userId, permissionId);
    }

    @Override
    public void deleteMenu(Map<String, String> params) {
        String userId = params.get("userId");
        String permissionId = params.get("permissionId");

        permissionMapper.deletePermissionForUser(userId, permissionId);
    }
}
