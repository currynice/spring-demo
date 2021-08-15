/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.cxy.springdemo.dependency.inject.setter;

import org.cxy.springdemo.business.domain.User;
import org.cxy.springdemo.dependency.inject.UserHolder;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * 依赖 Setter 方法注入示例
 *
 *
 * @since
 */
public class DependencySetterInjectionDemo {

    public static void main(String[] args) {
//        xmlWay();
        annotationWay();
//        apiWay();

    }


    public static void xmlWay(){

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);

        String xmlResourcePath = "classpath:/META-INF/dependency-injection-setter-context.xml";
        // 加载 XML 资源，解析并且生成 BeanDefinition
        beanDefinitionReader.loadBeanDefinitions(xmlResourcePath);
        // 依赖查找并且创建 Bean
        UserHolder userHolder = beanFactory.getBean(UserHolder.class);
        System.out.println(userHolder);
    }



    public static void annotationWay(){
        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册 Configuration Class（配置类）
        applicationContext.register(DependencySetterInjectionDemo.class);

        //注解同时支持xml
//        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);
//
//        String xmlResourcePath = "classpath:/META-INF/dependency-lookup-context.xml";
//        // 加载 XML 资源，解析并且生成 BeanDefinition
//        beanDefinitionReader.loadBeanDefinitions(xmlResourcePath);

        // 启动 Spring 应用上下文
        applicationContext.refresh();

        // 依赖查找并且创建 Bean
        UserHolder userHolder = applicationContext.getBean("userHolder2",UserHolder.class);
        System.out.println(userHolder);

        // 显示地关闭 Spring 应用上下文
        applicationContext.close();

    }


    public static void apiWay(){
        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(DependencySetterInjectionDemo.class);

        // 生成 UserHolder 的 BeanDefinition
        BeanDefinition userHolderBeanDefinition = createUserHolder3BeanDefinition();
        // 注册 UserHolder 的 BeanDefinition
        applicationContext.registerBeanDefinition("userHolder3", userHolderBeanDefinition);

        // 启动 Spring 应用上下文
        applicationContext.refresh();

        // 依赖查找并且创建 Bean
        UserHolder userHolder2 = applicationContext.getBean("userHolder2",UserHolder.class);
        System.out.println("userHolder2: "+userHolder2);

        UserHolder userHolder3 = applicationContext.getBean("userHolder3",UserHolder.class);
        System.out.println("userHolder3: "+userHolder3);

        // 显示地关闭 Spring 应用上下文
        applicationContext.close();
    }

    /**
     * 为 {@link UserHolder} 生成 {@link BeanDefinition}
     *
     * @return
     */
    private static BeanDefinition createUserHolder3BeanDefinition() {
        BeanDefinitionBuilder definitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(UserHolder.class);

        // addPropertyReference
        definitionBuilder.addPropertyReference("user", "user3");
        return definitionBuilder.getBeanDefinition();
    }

    @Bean
    public UserHolder userHolder2(User myUser) {
        UserHolder userHolder = new UserHolder();
        userHolder.setUser(myUser);
        return userHolder;
    }


    @Bean
    public User myUser() {
        User myUser = new User();
        myUser.setId("2");
        myUser.setName("setter-injection");
        return myUser;
    }


    @Bean
    public User user3() {
        User user3 = new User();
        user3.setId("3");
        user3.setName("setter-injection");
        return user3;
    }
}
