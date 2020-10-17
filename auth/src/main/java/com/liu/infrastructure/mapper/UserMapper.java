package com.liu.infrastructure.mapper;

import com.liu.domain.client.RoleModal;
import com.liu.infrastructure.pojo.CreateUserDO;
import com.liu.infrastructure.pojo.UpdateUserDO;
import com.liu.infrastructure.pojo.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
 * @author Liush
 * @description
 * @date 2020/9/27 10:29
 **/
@Mapper
public interface UserMapper {


    int saveUser(CreateUserDO user);

    UserDO findUserById(String id);

    int updateUserInfo(UpdateUserDO updateUserDO);

    Set<RoleModal> findRoleModalsByUserId(String userId);

    int insertUserRole(@Param("id") String id,@Param("userId") String userId,@Param("roleId") String roleId);

    int deleteUserRoleByUserId(@Param("userId") String userId);



}
