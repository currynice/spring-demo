package org.cxy.springdemo.bean.instantiation.staticFactory;

/**
 * Description: 创建 MyBean   </br>
 * Date: 2021/7/30 11:31
 *
 * @author :cxy </br>
 * @version : 1.0 </br>
 */
public class MyBeanStaticFactory {


    public static MyBean getBean(){
        return new MyBean();
    }

}
