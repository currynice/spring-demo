package org.cxy.springdemo.event.exceptionhandler;

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
public class RegService implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher publisher;

    public void register(int taskId) {
        System.out.println("注册:"+taskId);
        // 发布事件
        publisher.publishEvent(new TestEvent1(taskId));
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {

        this.publisher = publisher;
    }
}
