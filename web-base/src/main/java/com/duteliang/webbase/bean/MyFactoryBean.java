package com.duteliang.webbase.bean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @author: zl
 * @Date: 2019-12-14 14:07
 */
@Component
public class MyFactoryBean implements FactoryBean<MyBean> {
    @Override
    public MyBean getObject() {
        // 加入你的复杂的逻辑判断
        return new MyBean();
    }

    @Override
    public Class<MyBean> getObjectType() {
        return MyBean.class;
    }
}
