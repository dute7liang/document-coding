package com.duteliang.webbase.imp;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: zl
 * @Date: 2020/1/18 15:38
 */
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(AnnotationConfig.class);
        // 获取TestBean，如果获取不到会抛出异常NoSuchBeanDefinitionException
        System.out.println(app.getBean(TestBean.class));
    }

}
