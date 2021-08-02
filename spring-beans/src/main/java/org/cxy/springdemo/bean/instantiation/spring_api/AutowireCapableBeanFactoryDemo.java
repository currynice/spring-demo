package org.cxy.springdemo.bean.instantiation.spring_api;


import org.cxy.springdemo.business.domain.User;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 */
public class AutowireCapableBeanFactoryDemo {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/META-INF/service-loader-context.xml");
        AutowireCapableBeanFactory beanFactory = applicationContext.getAutowireCapableBeanFactory();

        User user = beanFactory.createBean(User.class);
        System.out.println(user);
    }
}
