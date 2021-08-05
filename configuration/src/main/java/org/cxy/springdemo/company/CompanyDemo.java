package org.cxy.springdemo.company;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
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
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();

//        ctx.getEnvironment().setActiveProfiles("working-day");


        //VM_OPTIONS: -Dspring.profiles.active=working-day

        System.out.println(Arrays.toString(ctx.getEnvironment().getActiveProfiles()));

        ctx.register(CompanyConfig.class);
        ctx.refresh();

        System.out.println("--------------------------");

        Stream.of(ctx.getBeanDefinitionNames()).forEach(System.out::println);
        System.out.println("--------------------------");

        ObjectProvider<Boss> provider = ctx.getBeanProvider(Boss.class);

        Boss boss = provider.getIfAvailable();
        Manager manager = ctx.getBean(Manager.class);
        ctx.getBeansOfType(Employee.class).entrySet().forEach(each->{
                     System.out.println("employee:"+each);
                }
        );
        System.out.println("boss:"+boss);
        System.out.println("manager:"+manager);

        ctx.close();
    }


}
