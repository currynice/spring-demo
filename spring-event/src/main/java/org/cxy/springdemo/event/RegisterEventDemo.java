package org.cxy.springdemo.event;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Description:   </br>
 * Date: 2021/8/4 17:39
 *
 * @author :cxy </br>
 * @version : 1.0 </br>
 */
public class RegisterEventDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
                "org.cxy.springdemo.event");
        RegisterService registerService = ctx.getBean(RegisterService.class);
        registerService.register("cxy");
        ctx.close();
    }
}
