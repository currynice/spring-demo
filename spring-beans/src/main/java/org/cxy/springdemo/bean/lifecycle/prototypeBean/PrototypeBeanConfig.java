package org.cxy.springdemo.bean.lifecycle.prototypeBean;


import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * Description:   </br>
 * Date: 2021/8/2 16:04
 *
 * @author :cxy </br>
 * @version : 1.0 </br>
 */
@Configuration
public class PrototypeBeanConfig {

    @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Brush brush() {
        return new Brush();
    }

}
