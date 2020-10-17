package com.liu.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @author Liush
 * @description
 * @date 2020/9/27 13:55
 **/
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserRoleDTO {

    private String id;
    private String name;
    private String mobile;

    private List<RoleDTO> roles;
}
