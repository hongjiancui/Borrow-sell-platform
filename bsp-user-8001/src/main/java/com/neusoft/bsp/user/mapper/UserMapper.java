package com.neusoft.bsp.user.mapper;

import com.neusoft.bsp.common.base.BaseMapper;
import com.neusoft.bsp.user.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper extends BaseMapper<String, User> {
    int getUsername(@Param("username") String username);

    int register(User user);

    String getLastId();

    User getUserByUsername(@Param("username") String username);
}
