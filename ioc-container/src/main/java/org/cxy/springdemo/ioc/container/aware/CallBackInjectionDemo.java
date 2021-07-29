package org.cxy.springdemo.ioc.container.aware;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Description: 回调注入  </br>
 * Date: 2021/7/29 17:03
 *
 * @author :cxy </br>
 * @version : 1.0 </br>
 */
public class CallBackInjectionDemo {

    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AwaredTestBeanConfig.class);
        AwaredTestBean bean = ctx.getBean(AwaredTestBean.class);
//        bean.printBeanNames();
//        System.out.println("xxxxxxx");
        bean.printMyBeanName();
    }
}
