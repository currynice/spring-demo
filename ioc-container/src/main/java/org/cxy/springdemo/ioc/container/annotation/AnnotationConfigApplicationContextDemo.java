package org.cxy.springdemo.ioc.container.annotation;

import org.cxy.springdemo.business.domain.A;
import org.cxy.springdemo.business.domain.Book;
import org.cxy.springdemo.business.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Description:  注解驱动 </br>
 * Date: 2021/7/28 11:19
 *
 * @author :cxy </br>
 * @version : 1.0 </br>
 */
public class AnnotationConfigApplicationContextDemo {

    public static void main(String[] args) {
        //扫描
        ApplicationContext ctx = new AnnotationConfigApplicationContext(QuickStartConfiguration.class);

        //扫描包下标记@Component的Bean
//        ApplicationContext ctx = new AnnotationConfigApplicationContext("com.linkedbear.spring.annotation.c_scan.bean");

//
//        User cxy =  ctx.getBean(User.class);
//        System.out.println(cxy);
//
//        Book book =  ctx.getBean(Book.class);
//        System.out.println(book);

//        User userDefineInXML =(User) ctx.getBean("user");
//        System.out.println(userDefineInXML);


        A a =(A) ctx.getBean("a");
        System.out.println(a);

    }
}
