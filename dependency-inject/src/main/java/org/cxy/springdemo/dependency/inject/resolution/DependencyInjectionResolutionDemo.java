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
package org.cxy.springdemo.dependency.inject.resolution;


import org.cxy.springdemo.business.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * 依赖注入处理过程
 *
 * @since
 */
@Configuration
public class DependencyInjectionResolutionDemo {



    // DependencyDescriptor ->
    // 必须（required=true）
    // 实时注入（eager=true)
    // 通过类型（User.class）
    // 字段名称（"user"）
    // 是否首要（primary = true)
    @Autowired          // 依赖查找（处理），找到 root
    private User user;

//    @Autowired          // 依赖查找（处理） + 延迟
//    @Lazy
//    private User lazyUser;

    @Autowired          // 集合类型依赖注入
    private List<User> users; // user superUser
//
//    @Autowired
//    private Optional<User> userOptional; // superUser



//    @Bean(name = AUTOWIRED_ANNOTATION_PROCESSOR_BEAN_NAME)
//    public static AutowiredAnnotationBeanPostProcessor beanPostProcessor() {
//        AutowiredAnnotationBeanPostProcessor beanPostProcessor = new AutowiredAnnotationBeanPostProcessor();
//        // @Autowired + @Inject +  新注解 @InjectedUser
//        Set<Class<? extends Annotation>> autowiredAnnotationTypes =
//                new LinkedHashSet<>(asList(Autowired.class, Inject.class, InjectedUser.class));
//        beanPostProcessor.setAutowiredAnnotationTypes(autowiredAnnotationTypes);
//        return beanPostProcessor;
//    }


    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册 Configuration Class（配置类)
        applicationContext.register(DependencyInjectionResolutionDemo.class);

        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);

        //定义了 root ,user 两个bean
        String xmlResourcePath = "classpath:/META-INF/dependency-lookup-context.xml";
        // 加载 XML 资源，解析并且生成 BeanDefinition
        beanDefinitionReader.loadBeanDefinitions(xmlResourcePath);

        // 启动 Spring 应用上下文
        applicationContext.refresh();

        // 依赖查找 DependencyInjectionResolutionDemo Bean
        DependencyInjectionResolutionDemo demo = applicationContext.getBean(DependencyInjectionResolutionDemo.class);

        // 期待输出 root Bean
        System.out.println("demo.user = " + demo.user);


        System.out.println("demo.user = " + demo.users);


        // 显示地关闭 Spring 应用上下文
        applicationContext.close();
    }

}
