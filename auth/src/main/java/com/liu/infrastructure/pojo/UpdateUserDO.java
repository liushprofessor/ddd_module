package com.liu.infrastructure.pojo;

/**
 * @author Liush
 * @description
 * @date 2020/10/10 13:24
 **/
public class UpdateUserDO extends UserDOAbstract {

    public UpdateUserDO() {
    }

    public UpdateUserDO(String id, String name, String mobile) {
        super(id, name, mobile);
    }
}
