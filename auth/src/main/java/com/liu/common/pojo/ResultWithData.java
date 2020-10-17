package com.liu.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Liush
 * @description
 * @date 2020/10/10 11:35
 **/

public class ResultWithData extends Result {

    private Object data;

    public ResultWithData(String code, String message, Object data) {
        super(code, message);
        this.data = data;
    }



    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
