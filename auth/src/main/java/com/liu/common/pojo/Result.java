package com.liu.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Liush
 * @description
 * @date 2020/9/27 13:31
 **/

public class Result {

    protected String code;

    protected String message;


    public Result(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
