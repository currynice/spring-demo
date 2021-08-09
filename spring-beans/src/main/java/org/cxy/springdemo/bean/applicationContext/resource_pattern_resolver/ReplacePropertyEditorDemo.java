package org.cxy.springdemo.bean.applicationContext.resource_pattern_resolver;

import org.springframework.beans.PropertyEditorRegistrySupport;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * todo
 */
public class ReplacePropertyEditorDemo {


    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext =
                new ClassPathXmlApplicationContext("classpath:META-INF/property-editor-context.xml");

        classPathXmlApplicationContext.getBeanFactory().addPropertyEditorRegistrar(registry -> {
            if (registry instanceof PropertyEditorRegistrySupport) {
                ((PropertyEditorRegistrySupport) registry).overrideDefaultEditor(boolean.class, new CustomBooleanEditor());
                System.out.println(((PropertyEditorRegistrySupport) registry).getDefaultEditor(boolean.class));
            } else {
                registry.registerCustomEditor(boolean.class, new CustomBooleanEditor());
            }
        });


        Object job = classPathXmlApplicationContext.getBean("job");
        System.out.println(job);

    }


}
