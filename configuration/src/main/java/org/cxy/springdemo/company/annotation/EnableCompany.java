package org.cxy.springdemo.company.annotation;

import org.cxy.springdemo.company.Boss;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * Description:
 *
 * 模仿 Springboot的 ConditionalOnBean
 *
 * Company模块自动装配注解，讲自动装配 Boss 和 Employee 组件
 * @Import({Boss.class})  标注了 @EnableCompany 注解，触发 @Import 的效果，向容器中导入一个 Boss 类型的 Bean 。
 *
 *
 *
 * </br>
 * Date: 2021/8/5 10:06
 *
 * @author :cxy </br>
 * @version : 1.0 </br>
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({CompanyConfigurationSelector.class,ManagerAutoRegister.class})
//@Import({CompanyConfigurationSelector.class,ManagerAutoRegister.class, Boss.class})
public @interface EnableCompany {
}
