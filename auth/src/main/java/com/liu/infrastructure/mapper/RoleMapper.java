package com.liu.infrastructure.mapper;

import com.liu.domain.client.RoleModal;
import com.liu.infrastructure.pojo.CreateRoleDO;
import com.liu.infrastructure.pojo.RoleDO;
import com.liu.infrastructure.pojo.UpdateRoleDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * @author Liush
 * @description
 * @date 2020/10/10 11:52
 **/
@Mapper
public interface RoleMapper {

    int insertRole(CreateRoleDO createRoleDO);

    RoleDO findRoleById(String id);

    Set<RoleModal> findRolesByIds(@Param("ids") Collection<String> ids);

    int updateRole(UpdateRoleDO updateRoleDO);
}
