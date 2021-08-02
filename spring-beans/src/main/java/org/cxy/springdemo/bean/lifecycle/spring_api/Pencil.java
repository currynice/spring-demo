package org.cxy.springdemo.bean.lifecycle.spring_api;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Description:   </br>
 * Date: 2021/8/2 15:34
 *
 * @author :cxy </br>
 * @version : 1.0 </br>
 */
//@Component
public class Pencil implements InitializingBean, DisposableBean {

    private Integer ink;


    @PostConstruct
    public void postConstructMethod() {
        System.out.println("@PostConstruct。。。");
    }


    @Override
    public void afterPropertiesSet() throws Exception {

        this.ink = 0;
        System.out.println("afterPropertiesSet in InitializingBean 。。。");

    }

    public void initMethod(){
        System.out.println("init-method。。。");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("@PreDestroy。。。");
    }


    @Override
    public void destroy() throws Exception {
        this.ink = 0;
        System.out.println("destroy in DisposableBean。。。");

    }


    public void destroyMethod(){
        System.out.println("destroy-method。。。");
    }


}
