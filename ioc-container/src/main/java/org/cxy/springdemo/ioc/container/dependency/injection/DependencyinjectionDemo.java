package org.cxy.springdemo.ioc.container.dependency.injection;


import org.cxy.springdemo.business.domain.Book;
import org.cxy.springdemo.business.domain.ComplexObject;
import org.cxy.springdemo.business.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 依赖注入示例
 *
 */
public class DependencyinjectionDemo {

    public static void main(String[] args) {
        //配置XML文件，启动 Spring 应用上下文 2
//        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-injection-context.xml");
//
//        User user = (User)beanFactory.getBean("user");
//        System.out.println(user);

        beanComplexInject();

    }


    /**
     * xml 复杂注入
     */
    private static void beanComplexInject(){

        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-complex-inject-context.xml");

        ComplexObject complexObject = ctx.getBean("complexObject",ComplexObject.class);

        System.out.println(complexObject);
    }





}
