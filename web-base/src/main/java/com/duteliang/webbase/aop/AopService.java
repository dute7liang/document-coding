package com.duteliang.webbase.aop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author: zl
 * @Date: 2020-1-16 15:30
 */
@Component
public class AopService implements AopServiceI{
    @Override
    public String aopTest(String name){
        System.out.println("我是AOP 实际方法：{}"+name);
        int i = 2/0;
        return name;
    }
}
