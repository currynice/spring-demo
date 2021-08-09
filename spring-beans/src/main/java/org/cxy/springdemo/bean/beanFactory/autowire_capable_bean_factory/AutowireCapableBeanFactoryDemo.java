package org.cxy.springdemo.bean.beanFactory.autowire_capable_bean_factory;

import org.cxy.springdemo.business.domain.User;
import org.cxy.springdemo.ioc.container.aware.AwaredTestBean;
import org.cxy.springdemo.ioc.container.aware.AwaredTestBeanConfig;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Description:   </br>
 * Date: 2021/8/3 11:21
 *
 * @author :cxy </br>
 * @version : 1.0 </br>
 */
public class AutowireCapableBeanFactoryDemo {


    /**
     * 两种方式 获取的是同一个
     * @param args
     */
    public static void main(String[] args) {
//        getAutowireCapableBeanFactoryByBeanFactoryAware();
        getAutowireCapableBeanFactoryInApplicationContext();
    }


    /**
     * 通过 Application#getAutowireCapableBeanFactory 获得 beanFactory(AutowireCapableBeanFactory)
     */
    public static void getAutowireCapableBeanFactoryInApplicationContext(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/META-INF/service-loader-context.xml");
        AutowireCapableBeanFactory beanFactory = applicationContext.getAutowireCapableBeanFactory();
        User user = beanFactory.createBean(User.class);
        System.out.println(user);
    }


    /**
     *  AutowireCapableBeanFactory可以借助BeanFactoryAware，
     *  以公开 beanFactory(AutowireCapableBeanFactory)
     */
    public static void getAutowireCapableBeanFactoryByBeanFactoryAware(){
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AwaredConfig.class);
        MyBeanFactoryAware beanFactoryAware = ctx.getBean(MyBeanFactoryAware.class);
        AutowireCapableBeanFactory beanFactory = (AutowireCapableBeanFactory) beanFactoryAware.myGetAutowireCapableBeanFactory();
        System.out.println(beanFactory.getBean("testUser"));
    }
}
