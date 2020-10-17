package com.liu.infrastructure.pojo;



/**
 * @author Liush
 * @description
 * @date 2020/9/27 15:01
 **/

public class CreateUserDO extends UserDOAbstract {

    protected String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
