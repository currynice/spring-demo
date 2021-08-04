package org.cxy.springdemo.event.listener;

import org.cxy.springdemo.event.events.RegisterSuccessEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Description:  发送站内信的监听器 </br>
 * Date: 2021/8/4 17:34
 *
 * @author :cxy </br>
 * @version : 1.0 </br>
 */
@Component
public class MessageSenderListener implements ApplicationListener<RegisterSuccessEvent> {

    @Override
    public void onApplicationEvent(RegisterSuccessEvent event){
        System.out.println("监听到用户注册成功，发送站内信。。。");
    }
}
