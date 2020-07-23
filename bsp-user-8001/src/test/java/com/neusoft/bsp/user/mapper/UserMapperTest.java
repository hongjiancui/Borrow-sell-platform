package com.neusoft.bsp.user.mapper;

import com.neusoft.bsp.user.entity.User;
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
public class UserMapperTest {
    @Resource
    private UserMapper userMapper;

    @Test
    public void getUsername(){
        int result_1 = userMapper.getUsername("admin");
        int result_2 = userMapper.getUsername("xxxxx");

        Assertions.assertEquals(1, result_1);
        Assertions.assertEquals(0, result_2);
    }

    @Test
    public void register() {
        User user = new User();
        user.setUsername("testUsername");
        user.setPassword("123456");
        user.setName("testName");
        user.setEmail("xxxx@gmail.com");
        user.setPhone("11111");

        int result = userMapper.register(user);
        Assertions.assertEquals(1, result);
    }

    @Test
    public void getUserByUsername() {
        User user = userMapper.getUserByUsername("mvo");
        System.out.println(user);
//        Assertions.assertEquals("admin", user.getUsername());
//        Assertions.assertEquals("123456", user.getPassword());
    }

    @Test
    public void getById() {
        User user = userMapper.getById("1");
        Assertions.assertEquals("admin", user.getUsername());
        Assertions.assertEquals("123456", user.getPassword());
    }
}
