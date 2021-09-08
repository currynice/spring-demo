package org.cxy.springdemo.bean.initAndDestory.springway;

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


        /**
         * 使用实现类, 目的是为了调用 close 方法对容器进行关闭(ApplicationContext 没有)，以触发 Bean 的销毁动作。
         */
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BeanLifeCycleConfig.class);
        Map<String, DemoBean> demoBeanMap = ctx.getBeansOfType(DemoBean.class);
        demoBeanMap.forEach((beanName, bean) -> {
            System.out.println(beanName + " : " + bean);
        });

        //关闭容器
        ctx.close();


    }
}
