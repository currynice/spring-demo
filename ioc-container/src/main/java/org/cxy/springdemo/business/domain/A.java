package org.cxy.springdemo.business.domain;

/**
 * Description:   </br>
 * Date: 2021/7/28 16:09
 *
 * @author :cxy </br>
 * @version : 1.0 </br>
 */
public class A {
    private String a;

    private B b;


    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "A{" +
                "a='" + a + '\'' +
                ", b=" + b +
                '}';
    }
}
