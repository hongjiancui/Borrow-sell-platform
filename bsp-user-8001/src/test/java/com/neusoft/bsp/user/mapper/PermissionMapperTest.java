package com.neusoft.bsp.user.mapper;

import com.neusoft.bsp.user.entity.User;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
public class PermissionMapperTest {
    @Resource
    private PermissionMapper permissionMapper;

    @Test
    public void addPermissionForUser() {
        String userId = "10";
        String permissionId = "1";

        int result = permissionMapper.addPermissionForUser(userId, permissionId);
        Assertions.assertEquals(1, result);
    }

    @Test
    public void deletePermissionForUser() {
        String userId = "10";
        String permissionId = "1";

        int result = permissionMapper.deletePermissionForUser(userId, permissionId);
        Assertions.assertEquals(1, result);
    }

    @Test
    public void getPermissionsOfUser() {
        List<User> permissionsOfUser = permissionMapper.getPermissionsOfUser();
        Assertions.assertTrue(permissionsOfUser.size() > 0);
    }
}
