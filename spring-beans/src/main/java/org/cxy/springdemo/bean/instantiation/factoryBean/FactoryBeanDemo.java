package org.cxy.springdemo.bean.instantiation.factoryBean;

import org.cxy.springdemo.business.domain.Toy;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

/**
 * Description:   </br>
 * Date: 2021/7/30 10:03
 *
 * @author :cxy </br>
 * @version : 1.0 </br>
 */
public class FactoryBeanDemo {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(ToyFactoryConfig.class);

//        Map<String, Toy> toys = ctx.getBeansOfType(Toy.class);
//        toys.forEach((name, toy) -> {
//            System.out.println("bean name : " + name + ", " + toy.toString());
//        });
    }
}
