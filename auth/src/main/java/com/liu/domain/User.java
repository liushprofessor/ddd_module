package com.liu.domain;

import org.mindrot.jbcrypt.BCrypt;

import java.util.Set;

/**
 * @author Liush
 * @description
 * @date 2020/9/26 8:36
 **/
public class User {

    private String id;

    private String name;

    private String mobile;

    private String password;

    private Set<String> roles;


    private User(String id, String name, String mobile, String password) {
        this.id = id;
        this.name = name;
        this.mobile = mobile;
        this.password = BCrypt.hashpw(password, BCrypt.gensalt());
    }

    private User(){}

    public static User createUser(String id, String name, String mobile, String password){
        return new User(id,name,mobile,password);
    }

    public static User restoreUser(String id, String name, String mobile, String password,Set<String> roleIds){
            User user=new User();
            user.id=id;
            user.name=name;
            user.mobile=mobile;
            user.password=password;
            user.roles=roleIds;
            return user;
    }

    public void authentication(String passwordAuthentication){
         if(!BCrypt.checkpw(password,passwordAuthentication)){
                throw new RuntimeException();
         }
    }


    public User modifyUserInfo(String name,String mobile){
        this.name=name;
        this.mobile=mobile;
        return this;
    }

    public void modifyPassword(String password){
        this.password= BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public void  modifyRoles(Set<String> roles){
        this.roles=roles;
    }


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMobile() {
        return mobile;
    }

    public Set<String> getRoles() {
        return roles;
    }
}
