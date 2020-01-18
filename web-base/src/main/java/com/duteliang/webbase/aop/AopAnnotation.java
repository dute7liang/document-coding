package com.duteliang.webbase.aop;

import java.lang.annotation.*;

/**
 * @author: zl
 * @Date: 2020/1/17 22:51
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface AopAnnotation {
}
