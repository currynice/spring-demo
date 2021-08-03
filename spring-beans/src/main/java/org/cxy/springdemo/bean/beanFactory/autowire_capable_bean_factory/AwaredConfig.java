package org.cxy.springdemo.bean.beanFactory.autowire_capable_bean_factory;

import org.cxy.springdemo.business.domain.User;
import org.cxy.springdemo.ioc.container.aware.AwaredTestBean;
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
public class AwaredConfig {


    @Bean
   public MyBeanFactoryAware myBeanFactoryAware(){
       return new MyBeanFactoryAware();
   }


   @Bean
    public User testUser(){
       User testUser =  new User();
       testUser.setName("testUser");
       return testUser;
   }


}
