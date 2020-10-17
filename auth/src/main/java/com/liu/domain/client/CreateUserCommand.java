package com.liu.domain.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Liush
 * @description
 * @date 2020/10/6 11:31
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserCommand {

    private String id;

    private String name;

    private String password;

    private String mobile;
}
