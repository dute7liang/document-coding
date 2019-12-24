package com.document.reflect;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author: zl
 * @Date: 2019-12-24 10:03
 */
@Getter
@Setter
@ToString
public class ReflectBean extends ReflectSuper implements ReflectInterface {

    private String name;

    private Integer age;

    public String pubName;

    public ReflectBean(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public ReflectBean() {
    }

    public void method(){
        System.out.println("这是一个方法");
    }

    private void priMethod(String name){
        System.out.println("这是一个静态方法");
    }
}
