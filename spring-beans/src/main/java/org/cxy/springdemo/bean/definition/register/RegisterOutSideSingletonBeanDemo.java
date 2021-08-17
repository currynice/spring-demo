package org.cxy.springdemo.bean.definition.register;

import org.springframework.beans.factory.config.SingletonBeanRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * Description: 外部单体Bean手动注册演示

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

        System.out.println("查找所有BeanDefinition，是否包含outside ？" + Arrays.asList(configApplicationContext.getBeanDefinitionNames()).contains("outside"));


        //（ getBeanNamesOfType 和 getBeansOfType 方法除外,你真想找还是能找得到的，只是这些一般都是Spring的内建Bean，不希望开发者使用。。。）
        System.out.println("getBeanNamesOfType可以获得外部bean"+Arrays.toString(configApplicationContext.getBeanNamesForType(OutSideBean.class)));


        System.out.println("getBeansOfType可以获得外部bean"+ configApplicationContext.getBeansOfType(OutSideBean.class));


        configApplicationContext.close();

    }


}

