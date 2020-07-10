package com.neusoft.bsp.user.mapper;

import com.neusoft.bsp.user.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PermissionMapper {
    int addPermissionForUser(@Param("userId") String user_id, @Param("permissionId") String permission_id);

    int deletePermissionForUser(@Param("userId") String user_id, @Param("permissionId") String permission_id);

    List<User> getPermissionsOfUser();
}
