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
package org.cxy.springdemo.dependency.inject.field;

import org.cxy.springdemo.business.domain.User;
import org.cxy.springdemo.dependency.inject.UserHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;
import javax.inject.Inject;

/**
 *       依赖字段注入示例(byType)
 *
 * @since
 */
public class DependencyFieldInjectionDemo {

    @Autowired(required = false)
    private NotHere notHere;

    @Autowired
    private User user1;

    @Autowired
    @Qualifier("user2")
    private User user2;

    @Resource
    private User user3;

    @Inject
    private User user4;


//    @Injec
//    private UserHolder userHolder3;

    public static void main(String[] args) {

        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册 Configuration Class（配置类） -> Spring Bean
        applicationContext.register(DependencyFieldInjectionDemo.class);

        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);

        String xmlResourcePath = "classpath:/META-INF/dependency-injection-field-context.xml";
        // 加载 XML 资源，解析并且生成 BeanDefinition
        beanDefinitionReader.loadBeanDefinitions(xmlResourcePath);

        // 启动 Spring 应用上下文
        applicationContext.refresh();

        // 依赖查找 DependencyFieldInjectionDemo Bean
        DependencyFieldInjectionDemo demo = applicationContext.getBean(DependencyFieldInjectionDemo.class);

        // @Autowired 字段关联
        System.out.println(demo.notHere);  //null

        System.out.println(demo.user1);
        System.out.println(demo.user2);

        System.out.println(demo.user1==demo.user3);

        System.out.println(demo.user1==demo.user4);




        // 显示地关闭 Spring 应用上下文
        applicationContext.close();
    }

}
