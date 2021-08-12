package org.cxy.springdemo.dependency.inject.autowire;

/**
 * Description:   </br>
 * Date: 2021/8/12 10:09
 *
 * @author :cxy </br>
 * @version : 1.0 </br>
 */
public class Dog {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }
}
