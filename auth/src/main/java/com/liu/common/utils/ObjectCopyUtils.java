package com.liu.common.utils;

import com.liu.domain.User;
import org.springframework.beans.BeanUtils;

/**
 * @author Liush
 * @description
 * @date 2020/10/6 11:56
 **/
public  class   ObjectCopyUtils {

    public static  <T> T copy(Object source,Class<T> c){
        try {
            T t=c.newInstance();
            BeanUtils.copyProperties(source,t);
            return t;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
