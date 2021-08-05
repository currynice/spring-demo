package org.cxy.springdemo.company.annotation;


import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

/**
 * Description: 较为通用的 Conditional 规则实现类   </br>
 * Date: 2021/8/5 13:17
 *
 * @author :cxy </br>
 * @version : 1.0 </br>
 */
public class OnBeanCondition implements Condition {


    /**
     * 用 BeanDefinition 做判断而不是 Bean ，考虑的是当条件匹配时，可能 Boss 还没被创建，导致条件匹配出现偏差。
     *
     * 然后，把这个 ExistBossCondition 规则类放入 @Conditional 注解中。
     * @param context
     * @param metadata
     * @return
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

        Map<String, Object> attributes = metadata.getAnnotationAttributes(ConditionalOnBean.class.getName());

        // 匹配类型
        Class<?>[] classes = (Class<?>[]) attributes.get("value");
        for (Class<?> clazz : classes) {
            if (!context.getBeanFactory().containsBeanDefinition(clazz.getName())) {
                return false;
            }
        }


        // 获取目标自定义注解ConditionalOnBean上的beanNames属性
        String[] beanNames = (String[]) attributes.get("beanNames");
        // 逐个校验IOC容器中是否包含传入的bean名称
        for (String beanName : beanNames) {
            if (!context.getBeanFactory().containsBeanDefinition(beanName)) {
                return false;
            }
        }
        return true;
    }
}
