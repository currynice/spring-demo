package org.cxy.springdemo.bean.definition.cover_beandefinition;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ImportResource;

/**
 * Description: 演示 ClassPathXml 解析的配置类时  </br>
 * Date: 2021/8/4 15:49
 *
 * @author :cxy </br>
 * @version : 1.0 </br>
 */
public class CoverBeanDefinitionDemo {


    public static void main(String[] args) {
        coverByConfiguration();
    }

    /**
     * 通过新的 一个标注 @Configuration 注解的配置类（其中定义了一些 新bean ）以覆盖 旧的 beanDefinition
     */
    public static void coverByConfiguration(){
//        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(OldConfiguration.class,NewConfiguration.class);

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(NewConfiguration.class,OldConfiguration.class);

        System.out.println(ctx.getBean("badBoy"));

    }
}
