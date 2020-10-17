package com.liu.infrastructure.pojo;

/**
 * @author Liush
 * @description
 * @date 2020/10/10 13:20
 **/
public class RoleDO {

    protected String id;

    protected String name;

    public RoleDO() {
    }

    public RoleDO(String id, String name) {
        this.id = id;
        this.name = name;
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
}
