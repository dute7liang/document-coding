package com.duteliang.webbase.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author: zl
 * @Date: 2020-1-16 15:31
 */
@Aspect
@Component
public class AopTestAspect {

    @Before("execution(public * com.duteliang.webbase.aop.*.*(..))")
    public void doBefore(){
        System.out.println("我是AOP 前置方法！");
    }


}
