package org.cxy.springdemo.bean.definition.bean_definition_overriding;

import org.cxy.springdemo.bean.beanFactory.listable_bean_factory.Boy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

/**
 * Description:   </br>
 * Date: 2021/8/4 15:53
 *
 * @author :cxy </br>
 * @version : 1.0 </br>
 */
@Configuration
@Order(2)
public class NewConfiguration {

    @Bean("badBoy")
    public Boy newBadBoy(){
        Boy newBadBoy = new Boy();
        newBadBoy.setVersion(2);
        return newBadBoy;
    }

}
