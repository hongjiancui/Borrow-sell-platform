package com.neusoft.bsp.user.mapper;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
@Transactional
public class RoleMapperTest {
    @Resource
    private RoleMapper roleMapper;

    @Test
    public void addRoleForUser() {
        String userId = "1";
        String roleId = "1";

        int result = roleMapper.addRoleForUser(userId, roleId);
        Assertions.assertEquals(1, result);
    }
}
