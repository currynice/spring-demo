package org.cxy.springdemo.event.listener;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Description:   </br>
 * Date: 2021/8/4 16:57
 *
 * @author :cxy </br>
 * @version : 1.0 </br>
 */
public class QuickStartListenerDemo {

    public static void main(String[] args) {
        System.out.println("IOC容器开始初始化。。。");
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
                "org.cxy.springdemo.event.listener");
        System.out.println("IOC容器初始化完成。。。");
        ctx.close();
        System.out.println("IOC容器关闭。。。");
    }
}
