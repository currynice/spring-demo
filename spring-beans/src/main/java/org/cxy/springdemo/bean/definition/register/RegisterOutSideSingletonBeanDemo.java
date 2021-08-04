package org.cxy.springdemo.bean.definition.register;

import org.springframework.beans.factory.config.SingletonBeanRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Description: 外部单体Bean注册演示

 *
 * 将一个已经实例化，初始化好的 外部 Bean 注册到Spring 容器
 * SingletonBeanRegistry#registerSingleton 注册的Bean 不会执行任何Spring Bean 初始化回调（InitializingBean#afterPropertiesSet） 和销毁回调 （DisposableBean#destroy）
 *
 *
 * </br>
 * Date: 2021/8/4 9:11
 *
 * @author :cxy </br>
 * @version : 1.0 </br>
 */
public class RegisterOutSideSingletonBeanDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext();

        OutSideBean outSideBean = new OutSideBean();

        configApplicationContext.refresh();

        SingletonBeanRegistry singletonBeanRegistry = configApplicationContext.getBeanFactory();

        singletonBeanRegistry.registerSingleton("outside",outSideBean);


        System.out.println("whether outSideBean == outside ?" + (outSideBean == configApplicationContext.getBean("outside")));

        configApplicationContext.close();

    }


}

