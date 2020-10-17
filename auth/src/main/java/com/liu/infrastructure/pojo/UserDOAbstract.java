package com.liu.infrastructure.pojo;

/**
 * @author Liush
 * @description
 * @date 2020/10/10 13:22
 **/
public class UserDOAbstract {

    protected String id;

    protected String name;

    protected String mobile;


    public UserDOAbstract() {
    }

    public UserDOAbstract(String id, String name, String mobile) {
        this.id = id;
        this.name = name;
        this.mobile = mobile;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
