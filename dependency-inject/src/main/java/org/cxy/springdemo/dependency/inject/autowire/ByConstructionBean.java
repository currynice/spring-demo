package org.cxy.springdemo.dependency.inject.autowire;

/**
 * Description:   </br>
 * Date: 2021/8/12 13:56
 *
 * @author :cxy </br>
 * @version : 1.0 </br>
 */
public class ByConstructionBean {

    private Dog dog3;

    public ByConstructionBean() {

    }



    public ByConstructionBean(Dog dog3) {
        this.dog3 = dog3;
    }


    @Override
    public String toString() {
        return "ByConstructionBean{" +
                "dog3=" + dog3 +
                '}';
    }
}
