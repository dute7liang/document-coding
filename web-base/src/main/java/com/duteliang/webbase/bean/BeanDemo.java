package com.duteliang.webbase.bean;

import com.duteliang.webbase.aop.AopAnnotation;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author: zl
 * @Date: 2019-12-13 16:56
 */
@Component
@Setter
@Getter
@ToString
@Slf4j
public class BeanDemo implements BeanNameAware, BeanFactoryAware, ApplicationContextAware , InitializingBean {

    private BeanDemo2 beanDemo2;

    @Autowired
    private MyBean myBean;

    @Autowired
    public void setBeanDemo2(BeanDemo2 beanDemo2) {
        this.beanDemo2 = beanDemo2;
        log.warn("BeanDemo 的注入！");
    }

    private String name = "name";

    private String age = "age";


    static {
        log.warn("BeanDemo的静态方法");
    }

    {
        log.warn("BeanDemo的构造方法");
    }

    public BeanDemo() {
        log.warn("BeanDemo的无参构造函数");
    }


    @Override
    public void setBeanName(String name) {
        this.name = name;
        log.warn("调用 BeanNameAware 方法,name={}",name);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        log.warn("调用 BeanFactoryAware 方法,beanFactory={}",beanFactory);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        beanDemo2 = null;
        log.warn("调用 ApplicationContextAware 方法,注入ApplicationContext ");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.warn("调用 afterPropertiesSet 方法");
    }

    @PostConstruct
    public void initMethod(){
        log.warn("调用 initMethod 初始化方法 ");
    }

    @PreDestroy
    public void destroyMethod(){
        log.warn("调用 destroyMethod 销毁方法 ");
    }
}
