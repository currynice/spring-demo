package org.cxy.springdemo.dependency.lookup.lazy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Description:   </br>
 * Date: 2021/8/10 9:50
 *
 * @author :cxy </br>
 * @version : 1.0 </br>
 */
@Configuration
public class FooConfiguration {

    private  FooRepository repository;


    /**
     * @Configuration类 从4.3开始，也允许在单构造函数场景中省略@Autowired
     * @param repository
     */
//    @Autowired
    public FooConfiguration(FooRepository repository) {
        this.repository = repository;
    }



//    @Bean
//    public FooService fooService2() {
//        return new FooService(this.repository);
//    }
}
