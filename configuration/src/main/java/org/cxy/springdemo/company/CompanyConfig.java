package org.cxy.springdemo.company;

import org.cxy.springdemo.company.annotation.ConditionalOnBean;
import org.cxy.springdemo.company.annotation.EnableCompany;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * Description:   </br>
 * Date: 2021/8/5 10:12
 *
 * @author :cxy </br>
 * @version : 1.0 </br>
 */
@Configuration
@EnableCompany
public class CompanyConfig {

    @Bean
    @ConditionalOnBean({Boss.class})
    public BeanNeedBoss beanNeedBoss(){
        return new BeanNeedBoss();
    }

}
