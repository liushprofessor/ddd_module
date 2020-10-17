package com.liu.domain.repository;

import com.liu.domain.User;
import com.liu.domain.client.UserRoleModal;

/**
 * @author Liush
 * @description
 * @date 2020/9/27 10:27
 **/
public interface UserRepository {

     User saveUser(User user);

     User restoreUserById(String id);

     User saveUserInfo(User user);

     User saveUserRole(User user);

     UserRoleModal findUserById(String id);




}
