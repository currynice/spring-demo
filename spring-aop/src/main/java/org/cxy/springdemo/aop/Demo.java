package org.cxy.springdemo.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("org.cxy.springdemo.aop")
@EnableAspectJAutoProxy(exposeProxy = true)
public class Demo {


    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Demo.class);

        ElectricService electricService = (ElectricService) ctx.getBean("electricService");


        electricService.charge();
    }
}
