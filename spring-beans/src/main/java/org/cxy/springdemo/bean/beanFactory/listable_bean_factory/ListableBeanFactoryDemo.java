package org.cxy.springdemo.bean.beanFactory.listable_bean_factory;

import org.cxy.springdemo.business.domain.Dog;
import org.cxy.springdemo.business.domain.User;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

import java.util.stream.Stream;

import static org.springframework.beans.factory.support.BeanDefinitionBuilder.genericBeanDefinition;

/**
 * Description: 演示 ListableBeanFactory特性演示  </br>
 * Date: 2021/8/3 9:57
 *
 * @author :cxy </br>
 * @version : 1.0 </br>
 */
public class ListableBeanFactoryDemo {

    public static void main(String[] args) {
        //定义资源
        ClassPathResource resource = new ClassPathResource("META-INF/listable_bean_factory_context.xml");
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        beanDefinitionReader.loadBeanDefinitions(resource);

        registerSingletonManual(beanFactory);

        System.out.println("加载容器中的Bean：");
        Stream.of(beanFactory.getBeanDefinitionNames()).forEach(System.out::println);

        System.out.println("getBeanNamesOfType：name of Girl："+ beanFactory.getBeanNamesForType(Girl.class));

        System.out.println("getBeansOfType：Girl："+ beanFactory.getBeansOfType(Girl.class));

    }


    /**
     *
     * 手动注册一个Bean， ConfigurableBeanFactory 的 registerSingleton 方法
     */
    private static void registerSingletonManual(DefaultListableBeanFactory beanFactory){

        // 手动注册一个单实例Bean
        beanFactory.registerSingleton("girl", new Girl());

    }

}
