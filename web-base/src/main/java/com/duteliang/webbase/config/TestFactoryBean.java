package com.duteliang.webbase.config;

import com.duteliang.webbase.bean.BeanDemo2;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @author: zl
 * @Date: 2019-12-17 14:38
 */
@Component
public class TestFactoryBean implements FactoryBean<BeanDemo2> {


    @Override
    public BeanDemo2 getObject() throws Exception {
        BeanDemo2 beanDemo2 = new BeanDemo2();
        beanDemo2.setName("bcjisbui1");
        return beanDemo2;
    }

    @Override
    public Class<?> getObjectType() {
        return BeanDemo2.class;
    }
}
