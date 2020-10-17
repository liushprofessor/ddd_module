package com.liu.controller.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @author Liush
 * @description
 * @date 2020/10/9 17:18
 **/
@Data
public class UpdateUserDTO {
    private String id;
    private String mobile;
    private String name;

    public UpdateUserDTO(String id, String mobile, String name) {
        this.id = id;
        this.mobile = mobile;
        this.name = name;
    }

    public UpdateUserDTO() {
    }
}
