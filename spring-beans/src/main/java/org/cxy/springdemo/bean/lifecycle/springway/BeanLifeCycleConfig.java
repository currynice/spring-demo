package org.cxy.springdemo.bean.lifecycle.springway;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Description:   </br>
 * Date: 2021/7/30 14:34
 *
 * @author :cxy </br>
 * @version : 1.0 </br>
 */
@Configuration
@ImportResource(locations = "classpath:META-INF/bean-lifecycle-context.xml")
public class BeanLifeCycleConfig {

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public DemoBean demoBean2(){
        DemoBean demoBean2 = new DemoBean();
        demoBean2.setName("cxy2");
        return demoBean2;
    }
}
