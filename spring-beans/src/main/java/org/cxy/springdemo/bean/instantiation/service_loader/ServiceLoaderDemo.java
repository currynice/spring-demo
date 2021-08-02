package org.cxy.springdemo.bean.instantiation.service_loader;

import org.cxy.springdemo.bean.instantiation.instanceFactory.Bean2;
import org.cxy.springdemo.bean.instantiation.instanceFactory.InstanceFactoryConfig;
import org.cxy.springdemo.bean.instantiation.instanceFactory.MyInstanceFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * Description: ServiceLoad方式演示，相当于jdk里的IOC 在Spring的适配  </br>
 * Date: 2021/8/2 13:59
 *
 * @author :cxy </br>
 * @version : 1.0 </br>
 */
public class ServiceLoaderDemo {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/META-INF/service-loader-context.xml");

        ServiceLoader<Bean3Service> serviceLoader = applicationContext.getBean("bean3ServiceLoader", ServiceLoader.class);
        ServiceLoader<Bean3Service> serviceLoader2 = applicationContext.getBean("bean3ServiceLoader2", ServiceLoader.class);


//        displayServiceLoader(serviceLoader);


    }

    public static void displayServiceLoader(ServiceLoader<Bean3Service> serviceLoader) {
        Iterator<Bean3Service> iterator = serviceLoader.iterator();

        while(iterator.hasNext()){
            Bean3Service service = iterator.next();
            System.out.println(service.getBean3());
        }
    }


    /**
     * 相同实现即使重复定义，会自动去重。
     */
    public static void serviceLoaderDemo(){
        ServiceLoader<Bean3Service> serviceLoader= ServiceLoader.load(Bean3Service.class,Thread.currentThread().getContextClassLoader());
        displayServiceLoader(serviceLoader);

    }
}
