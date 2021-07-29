package org.cxy.springdemo.business.domain;

import org.springframework.stereotype.Component;

/**
 * Description:   </br>
 * Date: 2021/7/28 16:09
 *
 * @author :cxy </br>
 * @version : 1.0 </br>
 */
@Component("b")
public class B {

    private String b;

    //构造器不必须是 public 的
    private B() {
    }
}
