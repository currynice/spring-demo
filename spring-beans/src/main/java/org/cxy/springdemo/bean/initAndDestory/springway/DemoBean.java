package org.cxy.springdemo.bean.initAndDestory.springway;

/**
 * Description: 用于演示 Spring Bean 的初始化回调  和 销毁回调  </br>
 * Date: 2021/7/30 13:30
 *
 * @author :cxy </br>
 * @version : 1.0 </br>
 */
public class DemoBean {

    private String name;


    public void init() {
        System.out.println(name + "被初始化了。。。");
    }
    public void destroy() {
        System.out.println(name + "被销毁了。。。");
    }

    public void setName(String name) {

        System.out.println("setName方法执行了。。。");
        this.name = name;
    }


}
