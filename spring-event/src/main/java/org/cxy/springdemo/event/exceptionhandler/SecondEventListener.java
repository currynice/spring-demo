package org.cxy.springdemo.event.exceptionhandler;

import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@Order(2)
public class SecondEventListener implements ApplicationListener<TestEvent1> {


    @Override
    public	void onApplicationEvent(TestEvent1	event)	{
        System.out.println(Thread.currentThread()+":listener2:"+this.toString()+"received:" +event);

    }
}

