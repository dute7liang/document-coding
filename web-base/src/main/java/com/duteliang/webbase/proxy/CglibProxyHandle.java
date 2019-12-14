package com.duteliang.webbase.proxy;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author: zl
 * @Date: 2019-12-14 16:03
 */
public class CglibProxyHandle implements MethodInterceptor {

    private Object obj;

    public Object getInstance(Object obj) {
        this.obj = obj;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.obj.getClass());
        // 设置回调方法
        enhancer.setCallback(this);
        // 创建代理对象
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("收钱");
        Object res = methodProxy.invokeSuper(o, objects);
        System.out.println("拿到电脑");
        System.out.println("发货");
        return res;
    }
}
