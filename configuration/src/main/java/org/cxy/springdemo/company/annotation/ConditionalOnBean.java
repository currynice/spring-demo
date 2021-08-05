package org.cxy.springdemo.company.annotation;

/**
 * Description:
 * 有较多的组件必须依赖另一些不同的组件，
 *  不可能每个组件都写一个 Condition 条件
 *
 *  因此将 匹配规则抽取为通用的方式， </br>
 *
 * Date: 2021/8/5 13:32
 *
 * @author :cxy </br>
 * @version : 1.0 </br>
 */

import org.springframework.context.annotation.Conditional;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Conditional(OnBeanCondition.class)
@Documented
public @interface ConditionalOnBean {


    /**
     * 存在指定的 Bean  (beanNames)时才匹配(register)
     * @return
     */
    String[] beanNames() default {};


    /**
     * 必须具备的bean 的ClassName
     * @return
     */
    Class[] value() default {};
}

