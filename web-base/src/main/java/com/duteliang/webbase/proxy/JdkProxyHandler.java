package com.duteliang.webbase.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author: zl
 * @Date: 2019-12-14 15:33
 */
public class JdkProxyHandler implements InvocationHandler {

    private Object object;

    public JdkProxyHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("收钱");
        Object result = method.invoke(object, args);
        System.out.println("拿到电脑");
        System.out.println("发货");
        return result;
    }
}
