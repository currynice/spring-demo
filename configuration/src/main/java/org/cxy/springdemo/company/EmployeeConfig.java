package org.cxy.springdemo.company;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Description:   </br>
 * Date: 2021/8/5 10:15
 *
 * @author :cxy </br>
 * @version : 1.0 </br>
 */
@Configuration
@Profile("working-day")
public class EmployeeConfig {


    @Bean
    public Employee  employee_1(){
        Employee employee_1 = new Employee();
        employee_1.setName("员工a");
        return employee_1;
    }

    @Bean
    public Employee  employee_2(){
        Employee employee_2 = new Employee();
        employee_2.setName("员工b");
        return employee_2;
    }
}
