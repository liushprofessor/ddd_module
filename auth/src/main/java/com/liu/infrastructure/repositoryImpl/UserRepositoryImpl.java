package com.liu.infrastructure.repositoryImpl;

import com.liu.domain.User;
import com.liu.domain.client.RoleModal;
import com.liu.domain.client.UserRoleModal;
import com.liu.domain.repository.UserRepository;
import com.liu.infrastructure.mapper.RoleMapper;
import com.liu.infrastructure.mapper.UserMapper;
import com.liu.infrastructure.pojo.CreateUserDO;
import com.liu.infrastructure.pojo.UpdateUserDO;
import com.liu.infrastructure.pojo.UserDO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * @author Liush
 * @description
 * @date 2020/9/27 10:28
 **/
@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private UserMapper userMapper;



    @Override
    public User saveUser(User user) {
        insertUser(convertToUserDO(user));
        return user;
    }


    @Override
    public User restoreUserById(String id) {
        return restoreUser(findUserDO(id), findUserRoleIds(id));
    }

    @Override
    public User saveUserInfo(User user) {
        updateUser(user);
        return user;

    }

    @Override
    public User saveUserRole(User user) {
        deleteUserRole(user);
        insertUserRoles(user);
        return user;
    }


    @Override
    public UserRoleModal findUserById(String id) {
        UserDO userDO =findUserDO(id);
        return buildUserRoleModal(userDO, findRoleModalsByUserId(userDO.getId()));

    }

    private UserRoleModal buildUserRoleModal(UserDO userDO, Set<RoleModal> roleModal) {
        return UserRoleModal.builder().id(userDO.getId()).mobile(userDO.getMobile()).name(userDO.getName()).roles(roleModal).build();
    }

    private Set<RoleModal> findRoleModalsByUserId(String id) {
        return userMapper.findRoleModalsByUserId(id);
    }

    private void insertUserRoles(User user) {
        if(user.getRoles()!=null){
            for (String roleId: user.getRoles()) {
                userMapper.insertUserRole(UUID.randomUUID().toString(),user.getId(),roleId);
            }

        }
    }

    private void deleteUserRole(User user) {
        userMapper.deleteUserRoleByUserId(user.getId());
    }


    private User restoreUser(CreateUserDO createUserDO, Set<String> roleIds) {
        return User.restoreUser(createUserDO.getId(), createUserDO.getName(), createUserDO.getMobile(), createUserDO.getPassword(),roleIds);
    }

    private Set<String> findUserRoleIds(String id) {
        Set<String> roleIds=new LinkedHashSet<>();
        Set<RoleModal> roleModals = findRoleModalsByUserId(id);
        if(!ObjectUtils.isEmpty(roleModals)){
            roleModals.forEach(e->roleIds.add(e.getId()));
        }
        return roleIds;

    }

    private UserDO findUserDO(String id) {
        return userMapper.findUserById(id);
    }


    private CreateUserDO convertToUserDO(User user) {
        CreateUserDO modal=new CreateUserDO();
        BeanUtils.copyProperties(user,modal);
        return modal;
    }



    private void updateUser(User user) {
         userMapper.updateUserInfo(convertToUpdateUserDO(user));
    }

    private UpdateUserDO convertToUpdateUserDO(User user) {
        return new UpdateUserDO(user.getId(),user.getName(),user.getMobile());
    }

    private void insertUser(CreateUserDO createUserDO) {
        userMapper.saveUser(createUserDO);
    }
}
