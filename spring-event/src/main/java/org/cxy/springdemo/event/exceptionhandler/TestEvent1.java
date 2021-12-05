package org.cxy.springdemo.event.exceptionhandler;

import org.springframework.context.ApplicationEvent;

public class TestEvent1 extends ApplicationEvent {

    public TestEvent1(Object source) {
        super(source);
    }
}
