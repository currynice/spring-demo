package org.cxy.springdemo.ioc.container.aware;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Description:   </br>
 * Date: 2021/7/29 17:22
 *
 * @author :cxy </br>
 * @version : 1.0 </br>
 */
@Configuration
public class AwaredTestBeanConfig {


    @Bean
   public AwaredTestBean awaredTestBean(){
       return new AwaredTestBean();
   }

}
