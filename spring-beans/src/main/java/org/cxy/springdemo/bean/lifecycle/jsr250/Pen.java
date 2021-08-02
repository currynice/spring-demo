package org.cxy.springdemo.bean.lifecycle.jsr250;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


/**
 * 钢笔与墨水，实例化: new Pen()，初始化:addInk，销毁:outwellInk：
 */
@Component
public class Pen {

    private Integer ink;


    @PostConstruct
    public void addInk() {
        System.out.println("初始化。。。");

        this.ink = 100;
    }

    @PreDestroy
    public void outwellInk() {
        System.out.println("销毁。。。");
        this.ink = 0;
    }

    @Override
    public String toString() {
        return "Pen{" + "ink=" + ink + '}';
    }
}
