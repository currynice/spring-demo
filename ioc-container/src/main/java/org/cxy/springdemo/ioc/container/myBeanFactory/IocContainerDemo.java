package org.cxy.springdemo.ioc.container.myBeanFactory;

import org.cxy.springdemo.business.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;


/**
 * 演示使用 BeanFactory api的场景：在不需要ApplicationContext 提供的丰富特性的情况下
 */
public class IocContainerDemo {


    public static void main(String[] args) {
        //创建BeanFactory容器
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);

        //xml 配置文件Classpath 路径
        String location = "classpath:META-INF/dependency-lookup-context.xml";

        int beanDefinitionsCount = reader.loadBeanDefinitions(location);

        //Bean定义的加载数量
        System.out.println(beanDefinitionsCount);

        //测试依赖查找
        lookupByName(beanFactory);
    }

    /**
     * 按名称（id）查找 ,即时
     * @param beanFactory
     */
    private static void lookupByName(BeanFactory beanFactory) {
        User user = (User) beanFactory.getBean("user");
        System.out.println("实时查找：" + user);
    }
}
