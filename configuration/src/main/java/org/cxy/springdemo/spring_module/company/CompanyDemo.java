package org.cxy.springdemo.spring_module.company;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;

import java.util.stream.Stream;

/**
 * Description:   </br>
 * Date: 2021/8/5 10:12
 *
 * @author :cxy </br>
 * @version : 1.0 </br>
 */
public class CompanyDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(CompanyConfig.class);


        Stream.of(ctx.getBeanDefinitionNames()).forEach(System.out::println);
        System.out.println("--------------------------");

        Boss boss = ctx.getBean(Boss.class);
        Manager manager = ctx.getBean(Manager.class);
        ctx.getBeansOfType(Employee.class).entrySet().forEach(each->{
                     System.out.println("employee:"+each);
                }
        );
        System.out.println("boss:"+boss);
        System.out.println("manager:"+manager);

    }
}
