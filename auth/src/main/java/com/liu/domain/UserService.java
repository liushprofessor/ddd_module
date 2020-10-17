package com.liu.domain;

import com.liu.domain.client.CreateUserCommand;
import com.liu.domain.client.UpdateUserCommand;
import com.liu.domain.client.UpdateUserRoleCommand;
import com.liu.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Liush
 * @description
 * @date 2020/9/26 21:25
 **/
@Service
public class UserService {

   @Autowired
   private UserRepository userRepository;




   public User createUser(CreateUserCommand createUserCommand){
            return saveUser(generateUser(createUserCommand));
   }



   public User modifyUser(UpdateUserCommand userCommand){
            User user = restoreUser(userCommand.getId());
            User userModified = modifyUserInfo(userCommand, user);
            return saveUserInfo(userModified);
    }


    @Transactional
    public User modifyUserRole(UpdateUserRoleCommand updateUserRoleCommand){
        User user=restoreUser(updateUserRoleCommand.getId());
        modifyRoles(user,updateUserRoleCommand);
        return saveUserRole(user);
    }




    private User saveUserRole(User user) {
        return userRepository.saveUserRole(user);
    }

    private void modifyRoles(User user,UpdateUserRoleCommand updateUserRoleCommand) {
        user.modifyRoles(updateUserRoleCommand.getRoles());
    }


    private User modifyUserInfo(UpdateUserCommand userCommand, User user) {
        return user.modifyUserInfo(userCommand.getName(),userCommand.getMobile());
    }

    private User restoreUser(String id ) {
        return userRepository.restoreUserById(id);
    }




    private User generateUser(CreateUserCommand createUserCommand) {
            return  User.createUser(createUserCommand.getId(), createUserCommand.getName(), createUserCommand.getMobile(), createUserCommand.getPassword());
     }


    private User saveUserInfo(User userModified) {
        return userRepository.saveUserInfo(userModified);
    }

    private User saveUser(User user) {
        return userRepository.saveUser(user);
    }



}
