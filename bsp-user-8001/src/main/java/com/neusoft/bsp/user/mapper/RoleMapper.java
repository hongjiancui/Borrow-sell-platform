package com.neusoft.bsp.user.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RoleMapper {
    int addRoleForUser(@Param("userId") String userId,
                       @Param("roleId") String roleId);
}
