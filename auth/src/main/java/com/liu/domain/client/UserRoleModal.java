package com.liu.domain.client;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

/**
 * @author Liush
 * @description
 * @date 2020/10/12 10:31
 **/
@Data
@Builder
public class UserRoleModal {

    private String id;
    private String name;
    private String mobile;
    private Set<RoleModal> roles;

}
