package org.cxy.springdemo.event.listener;

import org.cxy.springdemo.event.events.RegisterSuccessEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Description:  发送短信的监听器 </br>
 * Date: 2021/8/4 17:34
 *
 * @author :cxy </br>
 * @version : 1.0 </br>
 */
@Component
public class SmsSenderListener  {


    /**
     * 注解式监听器的触发时机比接口式监听器早
     * @param event
     */
    @EventListener
    public void onRegisterSuccessEvent(RegisterSuccessEvent event){
        System.out.println("监听到用户注册成功，发送短信。。。");
    }
}
