package com.liu.domain.client;

import lombok.Data;

/**
 * @author Liush
 * @description
 * @date 2020/10/9 17:25
 **/
@Data
public class UpdateUserCommand {

    private String id;

    private String name;

    private String mobile;
}
