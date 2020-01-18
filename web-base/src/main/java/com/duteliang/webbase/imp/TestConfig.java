package com.duteliang.webbase.imp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: zl
 * @Date: 2020/1/18 15:45
 */
@Configuration
public class TestConfig {

    @Bean
    public TestBean testBean(){
        return new TestBean();
    }


}
