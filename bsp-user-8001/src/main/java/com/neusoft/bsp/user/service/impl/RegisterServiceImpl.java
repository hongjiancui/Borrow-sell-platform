package com.neusoft.bsp.user.service.impl;

import com.neusoft.bsp.user.entity.DropShipper;
import com.neusoft.bsp.user.entity.User;
import com.neusoft.bsp.user.feign.DropShipperFeignService;
import com.neusoft.bsp.user.feign.WalletFeignService;
import com.neusoft.bsp.user.mapper.PermissionMapper;
import com.neusoft.bsp.user.mapper.RoleMapper;
import com.neusoft.bsp.user.mapper.UserMapper;
import com.neusoft.bsp.user.service.RegisterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class RegisterServiceImpl implements RegisterService {
    @Resource
    private UserMapper userMapper;

    @Resource
    private RoleMapper roleMapper;

    @Resource
    private PermissionMapper permissionMapper;

    @Resource
    private DropShipperFeignService dropShipperFeignService;

    @Resource
    private WalletFeignService walletFeignService;

    @Override
    public int getUsername(String username) {
        return userMapper.getUsername(username) == 0 ? 0 : 1;
    }

    @Override
    public User register(User user) {
        userMapper.register(user);

        //获取user表中刚创建的userID
        String uid = userMapper.getLastId();

        //绑定钱包账户
        Map<String, String> params = new HashMap<>();
        params.put("userId", uid);
        params.put("walletId", user.getWalletId());
        walletFeignService.binding(params);

        //添加注册用户角色
        roleMapper.addRoleForUser(uid, user.getRoleId());

        if (Integer.parseInt(user.getRoleId()) == 1) {
            //mvo权限添加
            for (int i = 1; i < 5; i++) {
                permissionMapper.addPermissionForUser(uid, String.valueOf(i));
            }
        }

        if (Integer.parseInt(user.getRoleId()) == 2) {
            //bvo权限添加
            for (int i = 5; i < 10; i++) {
                permissionMapper.addPermissionForUser(uid, String.valueOf(i));
            }

            //添加bvo默认借卖方信息
            DropShipper dropShipper = new DropShipper();
            dropShipper.setUserId(uid);
            dropShipperFeignService.addBvoInfo(dropShipper);
        }

        return userMapper.getById(uid);
    }
}
