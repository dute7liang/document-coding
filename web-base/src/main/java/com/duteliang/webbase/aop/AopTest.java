package com.duteliang.webbase.aop;

import org.springframework.stereotype.Component;

/**
 * @author: zl
 * @Date: 2020/1/17 23:25
 */
@Component
public class AopTest {

    private AopService aopService;

    public AopTest(AopService aopService, AopServiceI aopServiceI) {
        this.aopService = aopService;
        this.aopServiceI = aopServiceI;
    }

    private AopServiceI aopServiceI;

    public void call(){
//        aopService.aopTest2(new AopModel());
        aopServiceI.aopTest2(new AopModel());
    }

}
