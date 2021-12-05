package org.cxy.springdemo.event.exceptionhandler;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.core.annotation.Order;
import java.util.Random;

@Component
@Order(1)
public class FirstEventListener implements ApplicationListener<TestEvent1> {

    private Random random = new	Random();

    @Override
    public	void onApplicationEvent(TestEvent1	event)	{
        System.out.println(Thread.currentThread()+":listener1:"+this.toString()+"received:" +event);


        //执行过程中，偶尔会抛出异常
        if(random.nextInt(10)%2==1)
            throw	new	RuntimeException("exception	happen	on	first	listener");
    }
}

