package org.cxy.springdemo.dependency.inject.autowire;

/**
 * Description:   </br>
 * Date: 2021/8/12 10:09
 *
 * @author :cxy </br>
 * @version : 1.0 </br>
 */
public class ByTypeBean {

    private Dog dog2;


    public Dog getDog2() {
        return dog2;
    }

    public void setDog2(Dog dog2) {
        this.dog2 = dog2;
    }

    @Override
    public String toString() {
        return "ByTypeBean{" +
                "dog2=" + dog2 +
                '}';
    }
}
