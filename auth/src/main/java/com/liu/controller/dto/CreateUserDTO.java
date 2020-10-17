package com.liu.controller.dto;

import lombok.Data;

/**
 * @author Liush
 * @description
 * @date 2020/10/9 17:17
 **/
@Data
public class CreateUserDTO {
    private String id;
    private String mobile;
    private String password;
    private String name;

}
