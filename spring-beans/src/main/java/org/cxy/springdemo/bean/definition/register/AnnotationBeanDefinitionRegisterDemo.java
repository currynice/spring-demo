package org.cxy.springdemo.bean.definition.register;


import org.cxy.springdemo.business.domain.User;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.util.StringUtils;

import static org.springframework.beans.factory.support.BeanDefinitionBuilder.genericBeanDefinition;


/**
 * 注解 BeanDefinition 示例
 */
public class AnnotationBeanDefinitionRegisterDemo {

    public static void main(String[] args) {

        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
//        registerWithingAtBean(applicationContext);

//        registerWithingComponent(applicationContext);

//        registerWithingImport(applicationContext);


        // 通过 BeanDefinition 注册 API 实现 start

        // 1.命名 Bean 的注册方式
//        registerUserBeanDefinition(applicationContext, "user2");
        // 2. 非命名 Bean 的注册方法
        registerUserBeanDefinition(applicationContext);

        applicationContext.refresh();
        System.out.println("User 类型的所有 Beans" + applicationContext.getBeansOfType(User.class));
        applicationContext.close();

        // 通过 BeanDefinition 注册 API 实现 end

    }


    /**
     * 使用@Bean注册
     */
    public static void registerWithingAtBean(AnnotationConfigApplicationContext applicationContext){
        // 注册 Configuration Class（配置类,@Bean需要一个载体）
        applicationContext.register(ConfigDemo.class);
        // 启动 Spring 应用上下文
        applicationContext.refresh();
        //按照类型依赖查找
        System.out.println("User 类型的所有 Beans" + applicationContext.getBeansOfType(User.class));
        // 显示地关闭 Spring 应用上下文
        applicationContext.close();

    }


    /**
     * 使用@Component 注册
     */
    public static void registerWithingComponent(AnnotationConfigApplicationContext applicationContext){
        // 注册 Configuration Class（配置类,@Bean需要一个载体）
        applicationContext.register(TestComponent.class);
        // 启动 Spring 应用上下文
        applicationContext.refresh();
        //按照类型依赖查找
        System.out.println("TestComponent 类型的所有 Beans" + applicationContext.getBeansOfType(TestComponent.class));
        // 显示地关闭 Spring 应用上下文
        applicationContext.close();

    }


    /**
     * 使用@Import 注册
     */
    public static void registerWithingImport(AnnotationConfigApplicationContext applicationContext){
        // 注册 Configuration Class（配置类,@Bean需要一个载体）
        applicationContext.register(ImportWayConfig.class);
        // 启动 Spring 应用上下文
        applicationContext.refresh();
        //按照类型依赖查找
        System.out.println("ImportDemo 类型的所有 Beans" + applicationContext.getBeansOfType(ImportDemo.class));
        // 显示地关闭 Spring 应用上下文
        applicationContext.close();

    }

    /**
     * 命名 Bean 的注册方式
     * @param registry
     * @param beanName
     */
    public static void registerUserBeanDefinition(BeanDefinitionRegistry registry, String beanName) {
        //构建 BeanDefinition
        BeanDefinitionBuilder beanDefinitionBuilder = genericBeanDefinition(User.class);
        beanDefinitionBuilder
                .addPropertyValue("id", "222")
                .addPropertyValue("name", "cxy2");

        // 如果 beanName 参数存在时
        if (StringUtils.hasText(beanName)) {
            // 注册 BeanDefinition
            registry.registerBeanDefinition(beanName, beanDefinitionBuilder.getBeanDefinition());
        } else {
            // 非命名 Bean 注册方法
            BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinitionBuilder.getBeanDefinition(), registry);
        }

    }


    /**
     * 非命名 Bean 的注册方法
     * @param registry
     */
    public static void registerUserBeanDefinition(BeanDefinitionRegistry registry) {
        registerUserBeanDefinition(registry, null);
    }



}
