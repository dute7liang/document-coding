package com.duteliang.webbase.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author: zl
 * @Date: 2019-12-11 14:43
 */
@Slf4j
@Component
public class MyListener2 implements ApplicationListener<MyEvent2> {
    @Override
    public void onApplicationEvent(MyEvent2 event) {
        log.info("收到消息了:{}",event);
    }
}
