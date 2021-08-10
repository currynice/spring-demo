package org.cxy.springdemo.dependency.lookup.lazy;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

/**
 * Description:  演示ObjectFactory
 *
 * Bean 延迟依赖查找接口
 * 	• org.springframework.beans.factory.ObjectFactory
 * 	• org.springframework.beans.factory.ObjectProvider
 * 		• Spring 5 对 Java 8 特性扩展
 * 			• 函数式接口
 * 				• getIfAvailable(Supplier)
 * 				• ifAvailable(Consumer)
 * 			• Stream 扩展 - stream()
 *
 *
 *
 *
 *        延迟查找主要是给架构开发者使用的。非常典型的一个使用场景就是SpringBoot的自动配置，如LettuceConnectionConfiguration  用于创建RedisClient（创建时根据用户的需求来创建）。
 *
 *      那么有些必须属性是要在配置文件里配置的，比如ip，port这种。Lettuce创建RedisClient时候，从配置文件里读取这些数据来创建RedisClient。
 *
 *      但有些属性是非必须的，而且不能在配置文件里配置，比如开启读写分离，RedisClient在Lettuce内部，是通过一个Builder来创建的，如果要开启读写分离，需要你在这个Builder在执行build的过程中，额外加一行：clientConfigurationBuilder.readFrom(ReadFrom.REPLICA);
 *
 *      如何把这行代码加入到这个内部的build流程中?一种比较常见的思路，是使用模板方法，写一个抽象方法，调用抽象方法，具体实现交给开发人员。
 *
 *      因此Lettuce设计了 LettuceClientConfigurationBuilderCustomizer 类，有一个customize方法，把Builder作为参数传递进来。开发人员相当于现在都是在配置LettuceClientConfigurationBuilderCustomizer类。
 *
 *      但如果是开发人员去配置这个类，说明LettuceClientConfigurationBuilderCustomizer这个类还没有被实例化。但根据模板模式，流程中必须调用LettuceClientConfigurationBuilderCustomizer这个类的抽象方法，才能达到目的。
 *
 *     这个时候延迟加载，ObjectProvider的作用就体现出来了。他可以规定，他产生的是一个LettuceClientConfigurationBuilderCustomizer的对象，并且指定这个对象产生以后，做什么事情。比如调用customize方法。
 *
 *     如果用户配置了LettuceClientConfigurationBuilderCustomizer对象。那么在创建RedisClient的流程中，ObjectProvider就能拿到该对象，然后按照预先指定的动作执行，比如执行customize方法。
 *
 *    如果用户没配置，那么拿不到Bean对象，就什么都不做或者做一些默认的事情。
 * </br>
 * Date: 2021/8/10 8:52
 *
 * @author :cxy </br>
 * @version : 1.0 </br>
 */
public class ObjectFactoryDemo {

    @Bean
    public String bean1(){
        return "bean1";
    }


    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();


        ctx.register(FooService.class,FooRepository.class);

        ctx.refresh();

        System.out.println(Arrays.toString(ctx.getBeanDefinitionNames()));

//        System.out.println(ctx.getBean(FooRepository.class));


        ctx.close();

    }
}
