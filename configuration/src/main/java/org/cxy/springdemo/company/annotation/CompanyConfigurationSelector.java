package org.cxy.springdemo.company.annotation;

import org.cxy.springdemo.company.Boss;
import org.cxy.springdemo.company.EmployeeConfig;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * Description:   </br>
 * Date: 2021/8/5 10:58
 *
 * @author :cxy </br>
 * @version : 1.0 </br>
 */
public class CompanyConfigurationSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[] {Boss.class.getName(), EmployeeConfig.class.getName()};
    }
}
