package org.cxy.springdemo.bean.lifecycle.prototypeBean;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


public class Brush {

    private Integer ink;


    public void initMethod() {
        System.out.println("initMethod。。。");

        this.ink = 100;
    }

    public void destroyMethod() {
        System.out.println("destroyMethod。。。");
        this.ink = 0;
    }

    @Override
    public String toString() {
        return "Pen{" + "ink=" + ink + '}';
    }
}
