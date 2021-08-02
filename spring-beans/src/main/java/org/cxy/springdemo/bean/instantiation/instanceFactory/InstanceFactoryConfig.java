package org.cxy.springdemo.bean.instantiation.instanceFactory;

import org.springframework.context.annotation.Bean;

/**
 * Description:   </br>
 * Date: 2021/8/2 13:51
 *
 * @author :cxy </br>
 * @version : 1.0 </br>
 */
public class InstanceFactoryConfig {

//    <bean id="myInstanceFactory" class="org.cxy.springdemo.bean.instantiation.instanceFactory.DefaultMyInstanceFactory"/>
//    <bean id="bean2" factory-bean="myInstanceFactory" factory-method="getBean2"/>

    @Bean
    public MyInstanceFactory myInstanceFactory(){
        return new DefaultMyInstanceFactory();
    }

    @Bean
    public Bean2 bean2(MyInstanceFactory myInstanceFactory){
        return myInstanceFactory.getBean2();
    }
}
