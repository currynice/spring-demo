package org.cxy.springdemo.company.annotation;

import org.cxy.springdemo.company.Manager;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * Description:   </br>
 * Date: 2021/8/5 11:03
 *
 * @author :cxy </br>
 * @version : 1.0 </br>
 */
public class ManagerAutoRegister implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata metadata, BeanDefinitionRegistry registry) {
        registry.registerBeanDefinition("manager", new RootBeanDefinition(Manager.class));
    }

}
