package org.cxy.springdemo.bean.definition.metadata_config;


import org.cxy.springdemo.business.domain.User;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;

/**
 * Spring bean 元信息配置demo
 */
public class BeanMetaConfigDemo {

    public static void main(String[] args) {
        byProperties();
    }

    private static void byProperties(){

            DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
            // 实例化基于 Properties 资源 BeanDefinitionReader
            PropertiesBeanDefinitionReader beanDefinitionReader = new PropertiesBeanDefinitionReader(beanFactory);
            //the absolute path within the classpath
            String location = "META-INF/user.properties";
            // 基于 ClassPath 加载 properties 资源
            Resource resource = new ClassPathResource(location);
            // 指定字符编码 UTF-8(默认ISO-8855-1)
            EncodedResource encodedResource = new EncodedResource(resource, "UTF-8");
            int beanNumbers = beanDefinitionReader.loadBeanDefinitions(encodedResource);
            System.out.println("已加载 BeanDefinition 数量：" + beanNumbers);
            // 通过 Bean Id 和类型进行依赖查找
            User user = beanFactory.getBean("user", User.class);
            System.out.println(user);

    }
}
