package org.cxy.springdemo.bean.lifecycle.lazyInit;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Description:   </br>
 * Date: 2021/8/4 10:44
 *
 * @author :cxy </br>
 * @version : 1.0 </br>
 */
@Configuration
@ComponentScan("org.cxy.springdemo.bean.lifecycle.lazyInit")
public class LazyInitDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(LazyInitDemo.class);
        System.out.println("IOC初始化完成");
        System.out.println("尝试获取LazyDemoBean");
        ctx.getBean(LazyDemoBean.class);
        ctx.close();
    }
}
