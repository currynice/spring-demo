package org.cxy.springdemo.dependency.inject.autowire;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Primary;


/**
 * Description: Spring 自动注入示例   </br>
 * Date: 2021/8/12 9:19
 *
 * @author :cxy </br>
 * @version : 1.0 </br>
 */
@ImportResource("classpath:META-INF/bean-autowire-context.xml")
public class AutowireDemo {

    public static void main(String[] args) {
//        byName();
//        byType();
        byType2();
//        constructorBean();

    }

    /**
     * 通过 set方法自动 autowire
     */
    public static void byName(){
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AutowireDemo.class);

        System.out.println(ctx.getBean("byNameBean")); //ByNameBean{dog=Dog{name='dog'}}

    }



    public static void byType(){

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AutowireDemo.class);


        System.out.println(ctx.getBean("byTypeBean"));  //ByTypeBean{dog2=Dog{name='primary-dog'}}


    }


    public static void byType2(){

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AutowireDemo.class);


        System.out.println(ctx.getBean("byTypeBean2"));


    }


    /**
     * 特殊的 byType ,用于构造器参数
     */
    public static void constructorBean() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AutowireDemo.class);


        System.out.println(ctx.getBean("constructorBean"));
    }


    @Bean
    public Dog dog(){
        Dog dog = new Dog();
        dog.setName("dog");
        return dog;
    }


    @Bean
    @Primary
    public Dog primary(){
        Dog dog2 = new Dog();
        dog2.setName("primary-dog");
        return dog2;
    }



}
