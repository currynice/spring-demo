package org.cxy.springdemo.ioc.container.dependency.injection;


import org.cxy.springdemo.ioc.container.annotation.Super;
import org.cxy.springdemo.ioc.container.domain.User;
import org.cxy.springdemo.ioc.container.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * 依赖注入示例
 *
 */
public class DependencyinjectionDemo {

    public static void main(String[] args) {
        //配置XML文件，启动 Spring 应用上下文 2
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-injection-context.xml");

//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-injection-context.xml");

        UserRepository userRepository = beanFactory.getBean("userRepository", UserRepository.class);

        System.out.println(userRepository.getUsers());



    }





}
