package org.cxy.springdemo.event.exceptionhandler;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.scheduling.support.TaskUtils;

import java.util.concurrent.Executors;

import static org.springframework.context.support.AbstractApplicationContext.APPLICATION_EVENT_MULTICASTER_BEAN_NAME;

public class ExceptionHandleDemo {


    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext("org.cxy.springdemo.event.exceptionhandler");

        SimpleApplicationEventMulticaster simpleApplicationEventMulticaster =  ctx.getBean(APPLICATION_EVENT_MULTICASTER_BEAN_NAME, SimpleApplicationEventMulticaster.class);

        simpleApplicationEventMulticaster.setErrorHandler(TaskUtils.LOG_AND_SUPPRESS_ERROR_HANDLER);

        simpleApplicationEventMulticaster.setTaskExecutor(Executors.newFixedThreadPool(10));

        RegService registerService = ctx.getBean(RegService.class);
        for(int i=1;i<31;i++){
            registerService.register(i);
        }
        ctx.close();
    }

}
