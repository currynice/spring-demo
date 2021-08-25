package org.cxy.springdemo.bean.scope;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

/**
 * Description:   </br>
 * Date: 2021/8/2 16:07
 *
 * @author :cxy </br>
 * @version : 1.0 </br>
 */
public class BeanScopeDemo implements DisposableBean {


    @Autowired
    @Qualifier("singletonBrush")
    private Brush singletonBrush;

    @Autowired
    @Qualifier("singletonBrush")
    private Brush singletonBrush1;

    @Autowired
    @Qualifier("prototypeBrush")
    private Brush prototypeBrush;

    @Autowired
    @Qualifier("prototypeBrush")
    private Brush prototypeBrush1;

    @Autowired
    @Qualifier("prototypeBrush")
    private Brush prototypeBrush2;

    @Autowired
    private Map<String, Brush> brushes;



    @Autowired
    private ConfigurableListableBeanFactory beanFactory;


    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();

        ctx.register(BrushBeanConfig.class, BeanScopeDemo.class);
        ctx.refresh();


        // 结论一：
        // Singleton Bean 无论依赖查找还是依赖注入，均为同一个对象
        // Prototype Bean 无论依赖查找还是依赖注入，均为新生成的对象

        // 结论二：
        // 如果依赖注入集合类型的对象，Singleton Bean 和 Prototype Bean 均会存在一个
        // Prototype Bean 有别于其他地方的依赖注入 Prototype Bean

        // 结论三：
        // 无论是 Singleton 还是 Prototype Bean 均会执行初始化方法回调
        // 不过仅 Singleton Bean 会执行销毁方法回调

        scopedBeansByLookup(ctx);

//        scopedBeansByInjection(ctx);

        ctx.close();
    }




    private static void scopedBeansByLookup(AnnotationConfigApplicationContext applicationContext) {

        for (int i = 0; i < 1; i++) {
            // singletonBrush 是共享 Bean 对象
            Brush singletonBrush = applicationContext.getBean("singletonBrush", Brush.class);
            System.out.println("singletonBrush = " + singletonBrush);
            // prototypeBrush 是每次依赖查找均生成了新的 Bean 对象
            Brush prototypeBrush = applicationContext.getBean("prototypeBrush", Brush.class);
            System.out.println("prototypeBrush = " + prototypeBrush);
        }

    }



    private static void scopedBeansByInjection(AnnotationConfigApplicationContext applicationContext) {
        BeanScopeDemo beanScopeDemo = applicationContext.getBean(BeanScopeDemo.class);

        System.out.println("beanScopeDemo.singletonUser = " + beanScopeDemo.singletonBrush);
        System.out.println("beanScopeDemo.singletonUser1 = " + beanScopeDemo.singletonBrush1);

        System.out.println("beanScopeDemo.prototypeUser = " + beanScopeDemo.prototypeBrush);
        System.out.println("beanScopeDemo.prototypeUser1 = " + beanScopeDemo.prototypeBrush1);
        System.out.println("beanScopeDemo.prototypeUser2 = " + beanScopeDemo.prototypeBrush2);

        System.out.println("beanScopeDemo.users = " + beanScopeDemo.brushes);
    }


    /**
     * 尝试在销毁BeanScopeDemo 时，销毁  prototype 的bena
     * @throws Exception
     */
    @Override
    public void destroy() throws Exception {

        System.out.println("当前 BeanScopeDemo Bean 正在销毁中...");

        this.prototypeBrush.destroyMethod();
        this.prototypeBrush1.destroyMethod();
        this.prototypeBrush2.destroyMethod();
        // 销毁brushes 中的prototypeBrush 获取 BeanDefinition,
        for (Map.Entry<String, Brush> entry : this.brushes.entrySet()) {
            String beanName = entry.getKey();
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanName);
            if (beanDefinition.isPrototype()) { // 如果当前 Bean 是 prototype scope
                Brush brush = entry.getValue();
                brush.destroyMethod();
            }
        }

        System.out.println("当前 BeanScopeDemo Bean 销毁完成");
    }

}
