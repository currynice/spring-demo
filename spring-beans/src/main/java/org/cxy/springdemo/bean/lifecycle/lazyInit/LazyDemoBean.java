package org.cxy.springdemo.bean.lifecycle.lazyInit;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Description: 演示@Lazy 的Bean  </br>
 * Date: 2021/8/4 10:40
 *
 * @author :cxy </br>
 * @version : 1.0 </br>
 */
@Component
@Lazy
public class LazyDemoBean {

    private String name;

    public LazyDemoBean() {
        System.out.println("LazyDemoBean 实例化");
    }

    //初始化
    @PostConstruct
    public void init(){
        System.out.println("LazyDemoBean @PostConstruct初始化");
        this.name = "cxy";
    }


    @Override
    public String toString() {
        return "LazyDemoBean{" +
                "name='" + name + '\'' +
                '}';
    }
}
