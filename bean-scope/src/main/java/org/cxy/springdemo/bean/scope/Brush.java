package org.cxy.springdemo.bean.scope;

import org.springframework.beans.factory.BeanNameAware;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


public class Brush implements BeanNameAware {

    private Long time;

    //避免序列化，反序列化
    private transient String beanName;

    @PostConstruct
    public void initMethod() {
        System.out.println(beanName+"init。。。");
        this.time = 100L;
    }

    @PreDestroy
    public void destroyMethod() {
        System.out.println(beanName+"destroy。。。");
        this.time = 0L;
    }



    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Brush{" + "time=" + time + '}'+"@" + Integer.toHexString(hashCode());
    }

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }
}
