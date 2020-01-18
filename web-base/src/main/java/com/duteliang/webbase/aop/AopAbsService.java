package com.duteliang.webbase.aop;

/**
 * @author: zl
 * @Date: 2020/1/18 00:57
 */
public abstract class AopAbsService implements AopServiceI {

    @Override
    public String aopTest2(AopModel name){
        System.out.println("我是AOP1231 实际方法");
        return "name";
    }
}
