package com.liu.infrastructure.pojo;

import lombok.Data;

import java.util.Set;

/**
 * @author Liush
 * @description
 * @date 2020/10/10 16:42
 **/
@Data
public class UpdateUserRoleDO {

    private String id;

    private Set<String> roles;

}
