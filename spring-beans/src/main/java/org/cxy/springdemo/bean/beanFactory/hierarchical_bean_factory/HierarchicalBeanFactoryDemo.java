package org.cxy.springdemo.bean.beanFactory.hierarchical_bean_factory;

import org.cxy.springdemo.business.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.HierarchicalBeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 * Description:   </br>
 * Date: 2021/8/2 17:35
 *
 * @author :cxy </br>
 * @version : 1.0 </br>
 */
public class HierarchicalBeanFactoryDemo {

    public static void main(String[] args) {
        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(LocalConfig.class);

        // 1. 获取 HierarchicalBeanFactory <- ConfigurableBeanFactory <- ConfigurableListableBeanFactory
        ConfigurableListableBeanFactory beanFactory = applicationContext.getBeanFactory();
//        System.out.println("设置Parent 之前：当前 BeanFactory 的 Parent BeanFactory ： " + beanFactory.getParentBeanFactory());

        // 2. 设置 一个 Parent BeanFactory
        HierarchicalBeanFactory parentBeanFactory = createParentBeanFactory();
        beanFactory.setParentBeanFactory(parentBeanFactory);
//        System.out.println("设置Parent 之后：当前 BeanFactory 的 Parent BeanFactory ： " + beanFactory.getParentBeanFactory());



        // 启动应用上下文
        applicationContext.refresh();

        //在本地BeanFactory查找
//        displayContainsLocalBean(beanFactory, "local");
//        displayContainsLocalBean(parentBeanFactory, "parent");


//        displayContainsBean(beanFactory, "local");
//        displayContainsBean(parentBeanFactory, "parent");


        System.out.println("--------");

        ss(beanFactory);



        // 关闭应用上下文
        applicationContext.close();

    }

    private static void displayContainsBean(HierarchicalBeanFactory beanFactory, String beanName) {
        System.out.printf("当前 BeanFactory[%s] 是否包含 Bean[name : %s] : %s\n", beanFactory, beanName,
                containsBean(beanFactory, beanName));
    }


    //自拟的递归查找
    private static boolean containsBean(HierarchicalBeanFactory beanFactory, String beanName) {
        BeanFactory parentBeanFactory = beanFactory.getParentBeanFactory();

        // parentBeanFactory 非层级结构 则看自己
        if (!(parentBeanFactory instanceof HierarchicalBeanFactory)) {
            return beanFactory.containsLocalBean(beanName);
        }

        // parentBeanFactory 是层级结构 先看parentBeanFactory
        if (containsBean((HierarchicalBeanFactory) parentBeanFactory, beanName)) {
            return true;
        }
        // parentBeanFactory 是层级结构 且parentBeanFactory不包含, 则看自己
        return beanFactory.containsLocalBean(beanName);
    }


    private static void displayContainsLocalBean(HierarchicalBeanFactory beanFactory, String beanName) {
        System.out.printf("当前 BeanFactory[%s] 是否包含 Local Bean[name : %s] : %s\n", beanFactory, beanName,
                beanFactory.containsLocalBean(beanName));
    }





    /**
     * 创建一个 Parent BeanFactory
     * @return
     */
    private static ConfigurableListableBeanFactory createParentBeanFactory() {
        // 创建 BeanFactory 容器
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        // XML 配置文件 ClassPath 路径
        String location = "classpath:/META-INF/dependency-parent-context.xml";
        // 仅加载配置
        reader.loadBeanDefinitions(location);
        return beanFactory;
    }


//    根据 Bean 类型查找实例列表
//			• 集合类型：BeanFactoryUtils#beansOfTypeIncludingAncestors
    // 把子容器中的bean列表回到存放最终结果的集合中，以子容器优先，子容器没有的时候才会去找父容器。
    //  如果父子容器有同名的bean ，优先子容器的
    public static void ss(HierarchicalBeanFactory beanFactory){
        BeanFactoryUtils.beansOfTypeIncludingAncestors((ListableBeanFactory) beanFactory, User.class).entrySet().forEach(
          each->  {
              System.out.println("beanName:"+each.getKey()+"...bean:"+each.getValue());
          }
        );
    }

//		• 根据 Java 注解查找名称列表
//			• BeanFactoryUtils#beanNamesForTypeIncludingAncestors


}
