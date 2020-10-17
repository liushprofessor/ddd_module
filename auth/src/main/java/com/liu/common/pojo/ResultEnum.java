package com.liu.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public enum ResultEnum{
    SUCCESS("1","success"),
    FAIL("-1","系统错误");
    
    private String code;
    private String message;


}
