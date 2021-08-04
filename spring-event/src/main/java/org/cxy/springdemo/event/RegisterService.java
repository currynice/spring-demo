package org.cxy.springdemo.event;

import org.cxy.springdemo.event.events.RegisterSuccessEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

/**
 * Description: 注册Service  </br>
 * Date: 2021/8/4 17:37
 *
 * @author :cxy </br>
 * @version : 1.0 </br>
 */
@Service
public class RegisterService implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher publisher;

    public void register(String username) {
        // 用户注册的动作。。。
        System.out.println(username + "注册成功。。。");
        // 发布事件
        publisher.publishEvent(new RegisterSuccessEvent(username));
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }
}
