package org.cxy.springdemo.bean.instantiation.instanceFactory;


/**
 * Description:   </br>
 * Date: 2021/8/2 13:45
 *
 * @author :cxy </br>
 * @version : 1.0 </br>
 */
public interface MyInstanceFactory {

    default Bean2 getBean2(){
        return new Bean2();
    }

}
