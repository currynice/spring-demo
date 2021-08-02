package org.cxy.springdemo.bean.instantiation.factoryBean;

import org.cxy.springdemo.business.domain.Ball;
import org.cxy.springdemo.business.domain.Car;
import org.cxy.springdemo.business.domain.Child;
import org.cxy.springdemo.business.domain.Toy;
import org.springframework.beans.factory.FactoryBean;

/**
 * Description:   </br>
 * Date: 2021/7/30 10:05
 *
 * @author :cxy </br>
 * @version : 1.0 </br>
 */
public class ToyFactoryBean implements FactoryBean<Toy> {

    private Child child;

    public ToyFactoryBean() {
        System.out.println("ToyFactoryBean 初始化了。。。");
    }

    @Override
    public Toy getObject() throws Exception {
        switch (child.getWantToy()) {
            case "ball":
                return new Ball("ball");
            case "car":
                return new Car("car");
            default:
                // SpringFramework2.0开始允许返回null
                // 1.x 不允许
                return null;
        }    }

    @Override
    public Class<Toy> getObjectType() {
        return Toy.class;
    }

    public void setChild(Child child) {
        this.child = child;
    }
}
