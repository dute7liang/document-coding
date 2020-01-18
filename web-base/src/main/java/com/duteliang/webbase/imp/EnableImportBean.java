package com.duteliang.webbase.imp;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author: zl
 * @Date: 2020/1/18 15:29
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(TestImportBeanDefinitionRegistrar.class)
public @interface EnableImportBean {
}
