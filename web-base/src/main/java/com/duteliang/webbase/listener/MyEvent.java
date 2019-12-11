package com.duteliang.webbase.listener;

import org.springframework.context.ApplicationEvent;

/**
 * @author: zl
 * @Date: 2019-12-11 14:44
 */
public class MyEvent extends ApplicationEvent {
    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public MyEvent(Object source) {
        super(source);
    }
}

