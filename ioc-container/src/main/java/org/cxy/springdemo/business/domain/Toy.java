package org.cxy.springdemo.business.domain;

/**
 * Description:   </br>
 * Date: 2021/7/30 10:04
 *
 * @author :cxy </br>
 * @version : 1.0 </br>
 */
public abstract class Toy {

    private String name;

    public Toy(String name) {
        this.name = name;
        System.out.println("生产了一个Toy" + name);
    }

    @Override
    public String toString() {
        return "Toy{" +
                "name='" + name + '\'' +
                '}';
    }
}
