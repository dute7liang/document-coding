package com.duteliang.webbase.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author: zl
 * @Date: 2019-12-13 17:05
 */
@Component
@Slf4j
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof BeanDemo){
            log.warn("调用BeanPostProcessor 的初始化之前方法,Bean={}",bean.toString());
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof BeanDemo) {
            log.warn("调用BeanPostProcessor 的初始化之后方法,Bean={}", bean.toString());
        }
        return bean;
    }
}
