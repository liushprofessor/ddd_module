package com.liu.common.utils;

import com.liu.common.pojo.Result;
import com.liu.common.pojo.ResultEnum;
import com.liu.common.pojo.ResultWithData;

/**
 * @author Liush
 * @description
 * @date 2020/9/27 13:34
 **/
public class ResultUtil {


    public static Result success(){

        return new Result(ResultEnum.SUCCESS.getCode(),ResultEnum.SUCCESS.getMessage());
    }
    public static Result success(Object data){

        return new ResultWithData(ResultEnum.SUCCESS.getCode(),ResultEnum.SUCCESS.getMessage(),data);
    }

    public static Result fail(){

        return new Result(ResultEnum.FAIL.getCode(),ResultEnum.FAIL.getMessage());
    }

    public static Result failWithMessage(String message){

        return new Result(ResultEnum.FAIL.getCode(),message);
    }


}
