package org.cxy.springdemo.bean.lifecycle.prototypeBean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Description:   </br>
 * Date: 2021/8/2 16:07
 *
 * @author :cxy </br>
 * @version : 1.0 </br>
 */
public class PrototypeBeanLifeCycleDemo {

    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(PrototypeBeanConfig.class);
        System.out.println("IOC容器初始化完成。。。");
        System.out.println(ctx.getBean(Brush.class));
        ctx.close();
    }
}
