package com.liu.domain;

import com.liu.domain.client.CreateRoleCommand;
import com.liu.domain.client.RoleModal;
import com.liu.domain.client.UpdateRoleCommand;
import com.liu.domain.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * @author Liush
 * @description
 * @date 2020/10/10 17:33
 **/
@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public void createRole(CreateRoleCommand createRoleCommand){
        Role role = generateRole(createRoleCommand);
        saveRole(role);

    }


    public void modifyRole(UpdateRoleCommand updateRoleCommand){
        Role role=restoreRoleById(updateRoleCommand.getId());
        roleRepository.modifyRole(role);
    }


    public Role restoreRoleById(String id){

        return roleRepository.restoreRoleById(id);

    }

    public Set<RoleModal> findRoleByIds(Collection<String> ids){

        return roleRepository.findRolesByIds(ids);

    }

    public Set<RoleModal> findRolesByIds(List<String> ids){
       return roleRepository.findRolesByIds(ids);
    }



    private void saveRole(Role role) {
        roleRepository.saveRole(role);
    }

    private Role generateRole(CreateRoleCommand createRoleCommand) {
        return Role.createRole(createRoleCommand.getId(),createRoleCommand.getName());
    }


}
