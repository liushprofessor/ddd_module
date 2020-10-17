package com.liu.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

/**
 * @author Liush
 * @description
 * @date 2020/10/10 16:49
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserRoleDTO {

    private String id;

    private Set<String> roles;


}
