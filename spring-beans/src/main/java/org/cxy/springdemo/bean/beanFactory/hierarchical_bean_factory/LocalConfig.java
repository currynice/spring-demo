package org.cxy.springdemo.bean.beanFactory.hierarchical_bean_factory;

import org.cxy.springdemo.business.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LocalConfig {

//    @Bean
    public User user(){
        User local = new User();
        local.setId("1");
        local.setName("local");
        return local;
    }
}
