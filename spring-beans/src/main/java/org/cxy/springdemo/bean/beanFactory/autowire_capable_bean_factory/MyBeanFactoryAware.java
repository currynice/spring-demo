package org.cxy.springdemo.bean.beanFactory.autowire_capable_bean_factory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

/**
 * Description: 使用 BeanFactoryAware 以公开 BeanFactory实例  </br>
 * Date: 2021/8/3 11:21
 *
 * @author :cxy </br>
 * @version : 1.0 </br>
 */
public class MyBeanFactoryAware implements BeanFactoryAware {


    private BeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
            this.beanFactory = beanFactory;
    }


    public BeanFactory myGetAutowireCapableBeanFactory(){
        return beanFactory;
    }
}
