package com.liu.domain;


import java.util.Set;

/**
 * @author Liush
 * @description 角色
 * @date 2020/9/26 8:45
 **/
public class Role {

    private String id;

    private String name;



    private Role(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Role restoreRole(String id, String name){
        return new Role(id,name);

    }

    public static Role createRole(String id, String name){

        return new Role(id,name);
    }



    public void modifyRole(String name){
        this.name=name;
    }


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }


}
