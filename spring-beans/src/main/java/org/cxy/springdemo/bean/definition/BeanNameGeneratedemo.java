package org.cxy.springdemo.bean.definition;

public class BeanNameGeneratedemo {


    //Bean 名称生成器（BeanNameGenerator）
    //Spring Framework 2.0.3 引入，框架內建两种实现
    /*
    1.DefaultBeanNameGenerator：默认通用 BeanNameGenerator 实现

    generatedBeanName
    如果全路径类名为空
     -父Bean名字存在(Parent),generatedBeanName = "Parent$child"
     -工厂类Bean存在(FactoryBean),generatedBeanName = "FactoryBean$created"
    接着,
    -为内嵌Bean,id = generatedBeanName#随机数
    -非内嵌Bean,id = generatedBeanName#递增数


*/
//2.AnnotationBeanNameGenerator：基于注解扫描的 BeanNameGenerator 实现，始于Spring Framework 2.5
/*
判断是为注解-@Component等, 没有指定value的情况下,根据spring规则生成,
     -如果发现类的前两个字符都是大写，则直接返回类名; MYService
        -将类名的第一个字母转成小写，然后返回 MyService -> myService
*/
    public static void main(String[] args) {

    }
}
