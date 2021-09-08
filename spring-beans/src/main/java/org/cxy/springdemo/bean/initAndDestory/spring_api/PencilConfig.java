package org.cxy.springdemo.bean.initAndDestory.spring_api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Description:   </br>
 * Date: 2021/8/2 15:49
 *
 * @author :cxy </br>
 * @version : 1.0 </br>
 */
@Configuration
public class PencilConfig {


    @Bean(initMethod = "initMethod",destroyMethod = "destroyMethod")
    public Pencil pencil(){
        return new Pencil();
    }
}
