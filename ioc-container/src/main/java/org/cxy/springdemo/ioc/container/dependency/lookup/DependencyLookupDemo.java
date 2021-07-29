package org.cxy.springdemo.ioc.container.dependency.lookup;


import org.cxy.springdemo.business.annotation.Super;
import org.cxy.springdemo.business.domain.Dog;
import org.cxy.springdemo.business.domain.User;
import org.cxy.springdemo.business.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * 依赖查找示例
 * 1. 通过名称的方式来查找
 * 2. 通过类型的方式来查找
 *
 */
public class DependencyLookupDemo {

    public static void main(String[] args) throws Exception{
        //配置XML文件，启动 Spring 应用上下文1
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-lookup-context.xml");

        lookupByName(beanFactory);

//        lookupByType(beanFactory);

//        lookupInterfaceAndImpl(beanFactory);

//        lookupByCollectionType(beanFactory);
//
//        lookupByAnnotationType(beanFactory);



//        lookupInLazy(beanFactory);



    }






    /**
     * 按名称（id）查找 ,即时
     * @param beanFactory
     */
    private static void lookupByName(BeanFactory beanFactory) {
        User user = (User) beanFactory.getBean("user");
        System.out.println("实时查找：" + user);
    }



    /**
     * 按名称（id）延迟查找
     * 应用：即使bean不存在也可以使用缺省策略执行
     */
    private static void lookupInLazy(BeanFactory beanFactory) {
//        ObjectFactory<User> objectFactory = (ObjectFactory<User>) beanFactory.getBean("objectFactory");
//        User user = objectFactory.getObject();
        ApplicationContext ctx = (ApplicationContext)beanFactory;
        ObjectProvider<Dog> provider = ctx.getBeanProvider(Dog.class);
        //getObject 还是可能抛出异常 ，延后了异常可能出现的时机
//        System.out.println("延迟查找：" + provider.getObject());
        // defined instance  or  a new instance or a customer
        System.out.println("延迟查找：" + provider.getIfAvailable(Dog::new));

    }

    /**
     * 按类型(单个)查找
     */
    private static void lookupByType(BeanFactory beanFactory) {
        User user = beanFactory.getBean(User.class);
        System.out.println("按类型查找：" + user);
    }

    /**
     * 接口与实现类
     */
    private static void lookupInterfaceAndImpl(BeanFactory beanFactory) {
        UserRepository userRepository = beanFactory.getBean(UserRepository.class);
        System.out.println("查找接口与实现类：" + userRepository.allNames());

    }

    /**
     * 按类型(集合)查找----所有xx类型的对象
     */
    private static void lookupByCollectionType(BeanFactory beanFactory) {
//        if (beanFactory instanceof ListableBeanFactory) {
//            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
//            Map<String, UserRepository> userRepositoryMap = listableBeanFactory.getBeansOfType(UserRepository.class);
//            System.out.println("查找到的所有的 User 集合对象:");
//        userRepositoryMap.forEach((beanName, bean) -> {
//            System.out.println(beanName + " : " + bean);
//        });
//        }

        ApplicationContext ctx = (ApplicationContext) beanFactory;
        Map<String, UserRepository> beans = ctx.getBeansOfType(UserRepository.class);
        beans.forEach((beanName, bean) -> {
            System.out.println(beanName + " : " + bean);
        });

    }


    /**
     * 通过注解查找
     */
    private static void lookupByAnnotationType(BeanFactory beanFactory) {

        ApplicationContext ctx = (ApplicationContext) beanFactory;
        Map<String, Object> beans = ctx.getBeansWithAnnotation(Super.class);
        System.out.println("查找到的所有标注@Super 的对象：");
        beans.forEach((beanName, bean) -> {
            System.out.println(beanName + " : " + bean);
        });
    }



}
