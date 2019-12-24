package com.duteliang.webbase.config;

import com.duteliang.webbase.bean.BeanDemo2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: zl
 * @Date: 2019-12-17 14:40
 */
@Configuration
public class TestConfig {

    @Bean
    public TestBean testBean(BeanDemo2 beanDemo2){
        TestBean testBean = new TestBean();

        return testBean;
    }

}
