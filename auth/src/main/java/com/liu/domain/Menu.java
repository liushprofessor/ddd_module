package com.liu.domain;

import java.util.List;
import java.util.Set;

/**
 * @author Liush
 * @description
 * @date 2020/9/26 9:00
 **/
public class Menu {

    private String id;

    private String name;

    private String url;

    Set<String> buttons;

    public void modifyMenuInfo(String name,String url){
        this.name=name;
        this.url=url;
    }

    public void modifyButtons(Set<String> buttons){
        this.buttons=buttons;

    }



}
