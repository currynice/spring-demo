package org.cxy.springdemo.dependency.inject.lazy;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 延迟依赖注入示例
 */
public class LazyDependencyLazyInjectionDemo {


    public static void main(String[] args) {
//        setterLazy();
//        constructorLazy();
        fieldLazy();
    }

    public static void setterLazy(){
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Account.class,PeopleConfig.class);
        System.out.println(ctx.getBean(Account.class));
    }

    public static void constructorLazy(){
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Book.class,PeopleConfig.class);
        System.out.println(ctx.getBean(Book.class));
    }


    public static void fieldLazy(){
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(PeopleService.class,PeopleConfig.class);
        PeopleService peopleService = ctx.getBean(PeopleService.class);
        peopleService.test();
    }

}
