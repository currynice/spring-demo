package org.cxy.springdemo.ioc.container.dependency.lookup;


import org.cxy.springdemo.ioc.container.annotation.Super;
import org.cxy.springdemo.ioc.container.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * 依赖查找示例
 * 1. 通过名称的方式来查找
 * 2. 通过类型的方式来查找
 *
 */
public class DependencyLookupDemo {

    public static void main(String[] args) {
        //配置XML文件，启动 Spring 应用上下文1
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-lookup-context.xml");

//        lookupInRealTime(beanFactory);
//
//        lookupInLazy(beanFactory);


        lookupByType(beanFactory);
//        lookupByCollectionType(beanFactory);

        lookupByAnnotationType(beanFactory);


    }




    /**
     * 按名称（id）查找
     */
    private static void lookupInLazy(BeanFactory beanFactory) {
        ObjectFactory<User> objectFactory = (ObjectFactory<User>) beanFactory.getBean("objectFactory");
        User user = objectFactory.getObject();
        System.out.println("延迟查找：" + user);
    }

    private static void lookupInRealTime(BeanFactory beanFactory) {
        User user = (User) beanFactory.getBean("user");
        System.out.println("实时查找：" + user);
    }


    /**
     * 按类型(单个)查找
     */
    private static void lookupByType(BeanFactory beanFactory) {
        User user = (User) beanFactory.getBean(User.class);
        System.out.println("按类型查找：" + user);
    }

    /**
     * 按类型(集合)查找----所有xx类型的对象
     */
    private static void lookupByCollectionType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> users = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("查找到的所有的 User 集合对象：" + users);
        }
    }


    /**
     * 通过注解查找
     */
    private static void lookupByAnnotationType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> users = (Map) listableBeanFactory.getBeansWithAnnotation(Super.class);
            System.out.println("查找到的所有标注@Super 的 User 集合对象：" + users);
        }
    }



}
