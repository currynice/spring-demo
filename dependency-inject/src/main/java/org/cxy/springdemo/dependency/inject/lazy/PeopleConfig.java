package org.cxy.springdemo.dependency.inject.lazy;

import org.springframework.context.annotation.Bean;

public class PeopleConfig {


    @Bean
    public People cxy(){
        People people = new People();
        people.setName("cxy");
        return people;
    }
}
