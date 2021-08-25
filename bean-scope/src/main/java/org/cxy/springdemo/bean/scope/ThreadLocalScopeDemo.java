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
package org.cxy.springdemo.bean.scope;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;


/**
 * 自定义 Scope {@link ThreadLocalScope} 示例
 *
 * @author <a href="mailto:mercyblitz@gmail.com">Mercy</a>
 * @since
 */
public class ThreadLocalScopeDemo {

    @Bean
    @Scope(ThreadLocalScope.SCOPE_NAME)
    public Brush brush() {
        return createBrush();
    }

    private static Brush createBrush() {
        Brush brush = new Brush();
        brush.setTime(System.nanoTime());
        return brush;
    }

    public static void main(String[] args) {

        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册 Configuration Class（配置类） -> Spring Bean
        applicationContext.register(ThreadLocalScopeDemo.class);

        applicationContext.addBeanFactoryPostProcessor(beanFactory -> {
            // 注册自定义 scope
            beanFactory.registerScope(ThreadLocalScope.SCOPE_NAME, new ThreadLocalScope());
        });

        // 启动 Spring 应用上下文
        applicationContext.refresh();

//        inMultiThreads(applicationContext);

        inSingleThreads(applicationContext);

        // 关闭 Spring 应用上下文
        applicationContext.close();
    }

    private static void inMultiThreads(AnnotationConfigApplicationContext applicationContext) {

        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(() -> {
                Brush brush = applicationContext.getBean("brush", Brush.class);
                System.out.printf("[Thread id :%d] brush = %s%n", Thread.currentThread().getId(), brush);
            });

            // 启动线程
            thread.start();
            // 强制线程执行完成
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //单一线程
    private static void inSingleThreads(AnnotationConfigApplicationContext applicationContext) {

        for (int i = 0; i < 3; i++) {
                Brush brush = applicationContext.getBean("brush", Brush.class);
                System.out.printf("[Thread id :%d] brush = %s%n", Thread.currentThread().getId(), brush);


        }
    }
}
