package com.liu.infrastructure.repositoryImpl;

import com.liu.domain.Role;
import com.liu.domain.client.RoleModal;
import com.liu.domain.repository.RoleRepository;
import com.liu.infrastructure.mapper.RoleMapper;
import com.liu.infrastructure.pojo.CreateRoleDO;
import com.liu.infrastructure.pojo.RoleDO;
import com.liu.infrastructure.pojo.UpdateRoleDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Liush
 * @description
 * @date 2020/10/5 20:20
 **/
@Repository
public class RoleRepositoryImpl implements RoleRepository {

    @Autowired
    private RoleMapper roleMapper;


    @Override
    public Set<RoleModal> findRolesByIds(Collection<String> ids) {
        return roleMapper.findRolesByIds(ids);
    }

    @Override
    public void saveRole(Role role) {
        insertRole(role);

    }

    @Override
    public void modifyRole(Role role) {
        updateRole(role);
    }



    @Override
    public Role restoreRoleById(String id) {
        return restoreRole(findRoleDO(id));
    }




    private void updateRole(Role role) {
        roleMapper.updateRole(convertToUpdateRoleDO(role));
    }

    private Role restoreRole( RoleDO roleDO) {

       return Role.restoreRole(roleDO.getId(),roleDO.getName());
    }



    private RoleDO findRoleDO(String id) {
        return roleMapper.findRoleById(id);
    }


    private void insertRole(Role role) {
        roleMapper.insertRole(convertToCreateRoleDO(role));
    }

    private CreateRoleDO convertToCreateRoleDO(Role role) {
        return new CreateRoleDO(role.getId(),role.getName());
    }

    private UpdateRoleDO convertToUpdateRoleDO(Role role) {
        return new UpdateRoleDO(role.getId(),role.getName());
    }
}
