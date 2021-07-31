package org.cxy.springdemo.ioc.container.staticFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Description: 通过静态工厂创建  </br>
 * Date: 2021/7/30 11:25
 *
 * @author :cxy </br>
 * @version : 1.0 </br>
 */
public class StaticFactoryDemo {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:META-INF/staticFactory-context.xml");

        ctx.getBeansOfType(MyBean.class).forEach((beanName, each) -> {
            System.out.println(beanName + " : " + each);
        });
    }
}
