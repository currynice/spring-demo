package org.cxy.springdemo.bean.beanFactory.hierarchical_bean_factory;

import org.cxy.springdemo.business.domain.User;
import org.springframework.context.annotation.Bean;

/**
 * Description:   </br>
 * Date: 2021/8/2 17:36
 *
 * @author :cxy </br>
 * @version : 1.0 </br>
 */
public class Config2 {

    @Bean("user")
    public User user(){
        return new User();
    }
}
