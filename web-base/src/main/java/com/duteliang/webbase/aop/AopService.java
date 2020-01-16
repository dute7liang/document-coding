package com.duteliang.webbase.aop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author: zl
 * @Date: 2020-1-16 15:30
 */
@Component
@Slf4j
public class AopService implements AopServiceI{

    public String aopTest(String name){
        log.info("我是aop测试：{}",name);
        return name;
    }

}
