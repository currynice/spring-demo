package org.cxy.springdemo.ioc.container.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.stream.Stream;

/**
 * Description: 当 一个 AwaredTestBean object 被初始化好后，会回调把 ApplicationContext 传给它，
 * </br>
 * Date: 2021/7/29 17:17
 *
 * @author :cxy </br>
 * @version : 1.0 </br>
 */
public class AwaredTestBean implements ApplicationContextAware, BeanNameAware {

    private ApplicationContext ctx;

    private String myBeanName;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ctx = applicationContext;
    }


    //打印 ctx的所有 bean id
    public void printBeanNames() {
        Stream.of(ctx.getBeanDefinitionNames()).forEach(System.out::println);
    }

    //打印当前bean 的id
    public void printMyBeanName() {
        System.out.println(myBeanName);
    }

    @Override
    public void setBeanName(String name) {
        myBeanName = name;
    }
}
