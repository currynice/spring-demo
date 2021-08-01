package org.cxy.springdemo.bean.definition.register;

import org.cxy.springdemo.business.domain.User;
import org.springframework.context.annotation.Bean;

public class ConfigDemo {

    // 1. 注册方式1 ：通过 @Bean 方式定义

    /**
     * 定义了一个 Bean
     */
    @Bean(name = "cxy1")
    public User user() {
        User user = new User();
        user.setId("007");
        user.setName("cxy1");
        return user;
    }
}
