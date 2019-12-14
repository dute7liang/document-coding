package com.duteliang.webbase.bean;

import javax.annotation.PostConstruct;

/**
 * @author: zl
 * @Date: 2019-12-14 14:07
 */
public class MyBean {

    @PostConstruct
    public void init(){
        System.out.println("222");
    }
}
