package org.cxy.springdemo.bean.instantiation.instanceFactory;

import org.cxy.springdemo.business.domain.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Description:   </br>
 * Date: 2021/8/2 13:59
 *
 * @author :cxy </br>
 * @version : 1.0 </br>
 */
public class InstanceFactoryDemo {

    public static void main(String[] args) {
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean/bean-instantiate.xml");
        ApplicationContext ctx = new AnnotationConfigApplicationContext(InstanceFactoryConfig.class);

        ctx.getBeansOfType(Bean2.class).forEach((beanName, bean2) -> {
            System.out.println(beanName + " : " + bean2);
        });
        // 尝试取一下试试
        System.out.println(ctx.getBean(MyInstanceFactory.class));
        System.out.println(ctx.getBean(InstanceFactoryConfig.class));

    }
}
