package org.cxy.springdemo.spring_module.company;

/**
 * Description:   </br>
 * Date: 2021/8/5 10:16
 *
 * @author :cxy </br>
 * @version : 1.0 </br>
 */
public class Employee {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                '}';
    }
}
