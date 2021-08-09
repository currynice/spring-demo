package org.cxy.springdemo.ioc.container.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Description: 当 一个 AwaredTestBean object 被初始化好后，会回调把 ApplicationContext 传给它，
 * </br>
 * Date: 2021/7/29 17:17
 *
 * @author :cxy </br>
 * @version : 1.0 </br>
 */
public class AwaredTestBean implements ApplicationContextAware, BeanNameAware, EnvironmentAware {

    private ApplicationContext ctx;

    private String myBeanName;

    private Environment environment;


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ctx = applicationContext;
    }



    public void print() {
        //打印 ctx 定义 的所有的  bean id
        System.out.println("打印 ctx 定义 的所有的 bean-Name");
        Stream.of(ctx.getBeanDefinitionNames()).forEach(System.out::println);

        //打印当前bean 的id
        System.out.println("打印当前的 bean-Name");
        System.out.println(myBeanName);

        //打印当前bean 的id
        System.out.println("runtime-getDefaultProfiles");
        System.out.println(Arrays.toString(environment.getDefaultProfiles()));
        System.out.println("runtime-getActiveProfiles");
        System.out.println(Arrays.toString(environment.getActiveProfiles()));

    }

    @Override
    public void setBeanName(String name) {
        myBeanName = name;
    }


    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
