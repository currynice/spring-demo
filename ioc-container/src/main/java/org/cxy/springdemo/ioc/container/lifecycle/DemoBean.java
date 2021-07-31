package org.cxy.springdemo.ioc.container.lifecycle;

/**
 * Description:   </br>
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
        this.name = name;
    }


}
