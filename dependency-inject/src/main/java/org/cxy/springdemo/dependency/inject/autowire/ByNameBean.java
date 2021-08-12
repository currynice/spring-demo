package org.cxy.springdemo.dependency.inject.autowire;

/**
 * Description:   </br>
 * Date: 2021/8/12 10:09
 *
 * @author :cxy </br>
 * @version : 1.0 </br>
 */
public class ByNameBean {

    private Dog dog;


    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }


    @Override
    public String toString() {
        return "ByNameBean{" +
                "dog=" + dog +
                '}';
    }
}
