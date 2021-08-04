package org.cxy.springdemo.event.listener;

import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Description:   </br>
 * Date: 2021/8/4 16:56
 *
 * @author :cxy </br>
 * @version : 1.0 </br>
 */
@Component
public class ContextClosedEventApplicationListener {


    @EventListener
    public void onApplicationEvent(ContextClosedEvent event) {
        System.out.println("ContextClosedEventApplicationListener监听到ContextClosedEvent事件！");
    }
}
