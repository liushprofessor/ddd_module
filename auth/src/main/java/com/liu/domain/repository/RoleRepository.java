package com.liu.domain.repository;

import com.liu.domain.Role;
import com.liu.domain.client.RoleModal;

import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * @author Liush
 * @description
 * @date 2020/10/5 20:13
 **/
public interface RoleRepository {

    Set<RoleModal> findRolesByIds(Collection<String> ids);

    void saveRole(Role role);

    void modifyRole(Role role);

    Role restoreRoleById(String id);




}
