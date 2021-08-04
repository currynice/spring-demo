package org.cxy.springdemo.event.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Description: ContextRefreshedEvent ApplicationContext启动 事件的监听器 </br>
 * Date: 2021/8/4 16:54
 *
 * @author :cxy </br>
 * @version : 1.0 </br>
 */
@Component
public class ContextRefreshedApplicationListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("ContextRefreshedApplicationListener监听到ContextRefreshedEvent事件！");
    }
}
