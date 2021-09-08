package org.cxy.springdemo.bean.initAndDestory.spring_api;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

/**
 * Description:  </br>
 * Date: 2021/8/2 15:39
 *
 * @author :cxy </br>
 * @version : 1.0 </br>
 */
public class InitializingDisposableDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext("org.cxy.springdemo.bean.lifecycle.spring_api");
        Map<String, Pencil> demoBeanMap = ctx.getBeansOfType(Pencil.class);
        demoBeanMap.forEach((beanName, bean) -> {
            System.out.println(beanName + " : " + bean);
        });

        //关闭容器
        ctx.close();
    }
}
