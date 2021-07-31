package org.cxy.springdemo.ioc.container.beanScope;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Description:   </br>
 * Date: 2021/7/30 10:52
 *
 * @author :cxy </br>
 * @version : 1.0 </br>
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TestBean {

    public TestBean() {
        System.out.println("TestBean constructor run ...");
    }
}
