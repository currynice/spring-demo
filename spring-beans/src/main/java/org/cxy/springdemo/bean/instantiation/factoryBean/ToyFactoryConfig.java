package org.cxy.springdemo.bean.instantiation.factoryBean;

import org.cxy.springdemo.business.domain.Child;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Description:   </br>
 * Date: 2021/7/30 10:23
 *
 * @author :cxy </br>
 * @version : 1.0 </br>
 */
@Configuration
public class ToyFactoryConfig {
    @Bean
    public Child child() {
        return new Child();
    }

//
//    @Bean
//    public Toy ball() {
//        return new Ball("ball");
//    }

    @Bean
    public ToyFactoryBean toyFactory() {
        ToyFactoryBean toyFactory = new ToyFactoryBean();
        toyFactory.setChild(child());
        return toyFactory;
    }

}
