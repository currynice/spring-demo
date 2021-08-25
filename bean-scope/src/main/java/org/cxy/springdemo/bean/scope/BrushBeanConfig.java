package org.cxy.springdemo.bean.scope;


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
public class BrushBeanConfig {

    // 默认 scope 就是 "singleton"
    @Bean
    public Brush singletonBrush() {
        return createBrush();
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Brush prototypeBrush() {
        return createBrush();
    }



    private static Brush createBrush() {
        Brush brush = new Brush();
        brush.setTime(System.nanoTime());
        return brush;
    }

}
