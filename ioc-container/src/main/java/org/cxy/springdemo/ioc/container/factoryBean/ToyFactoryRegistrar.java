package org.cxy.springdemo.ioc.container.factoryBean;

import org.cxy.springdemo.business.domain.Ball;
import org.cxy.springdemo.business.domain.Child;
import org.cxy.springdemo.business.domain.Toy;
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
public class ToyFactoryRegistrar {
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
