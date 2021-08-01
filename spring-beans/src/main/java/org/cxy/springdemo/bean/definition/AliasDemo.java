package org.cxy.springdemo.bean.definition;


import org.cxy.springdemo.business.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Bean 别名（Alias）的价值
 * • 复用现有的 BeanDefinition
 * • 更具有场景化的命名方法，比如：
 * <alias name="myApp-dataSource" alias="subsystemA-dataSource"/>
 * <alias name="myApp-dataSource" alias="subsystemB-dataSource"/>
 *
 */
public class AliasDemo {


    public static void main(String[] args) {
        // 配置 XML 配置文件
        // 启动 Spring 应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-definition-alias-context.xml");
        // 通过别名 xiaomage-user 获取曾用名 user 的 bean
        User user = beanFactory.getBean("user", User.class);
        User cxy = beanFactory.getBean("cxy-user", User.class);
        System.out.println("cxy-user 是否与 user Bean 相同：" + (user == cxy));
    }
}
