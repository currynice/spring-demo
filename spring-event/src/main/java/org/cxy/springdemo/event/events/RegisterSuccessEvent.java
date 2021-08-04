package org.cxy.springdemo.event.events;

import org.springframework.context.ApplicationEvent;

/**
 * Description: 自定义注册成功事件  </br>
 * Date: 2021/8/4 17:33
 *
 * @author :cxy </br>
 * @version : 1.0 </br>
 */
public class RegisterSuccessEvent extends ApplicationEvent {
    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public RegisterSuccessEvent(Object source) {
        super(source);
    }
}
