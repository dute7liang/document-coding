package com.duteliang.webbase.aop;

import org.springframework.stereotype.Component;

/**
 * @author: zl
 * @Date: 2020-1-16 15:30
 */
@Component
@AopAnnotation
public class AopService extends AopAbsService implements AopServiceI{

    public String aopTest(String name){
        System.out.println("我是AOP 实际方法");
        return name;
    }

}
