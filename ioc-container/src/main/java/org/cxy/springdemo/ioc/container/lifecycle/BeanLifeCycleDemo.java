package org.cxy.springdemo.ioc.container.lifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.Map;

/**
 * Description:   </br>
 * Date: 2021/7/30 13:31
 *
 * @author :cxy </br>
 * @version : 1.0 </br>
 */
public class BeanLifeCycleDemo {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(BeanLifeCycleConfig.class);
        Map<String, DemoBean> demoBeanMap = ctx.getBeansOfType(DemoBean.class);
        demoBeanMap.forEach((beanName, bean) -> {
            System.out.println(beanName + " : " + bean);
        });
    }
}
