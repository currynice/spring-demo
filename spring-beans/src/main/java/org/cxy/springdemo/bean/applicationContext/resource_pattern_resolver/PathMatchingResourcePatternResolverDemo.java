package org.cxy.springdemo.bean.applicationContext.resource_pattern_resolver;

import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

/**
 * Description: 一个独立实现，根据特殊路径返回匹配到的资源。可以在ApplicationContext 外单独使用。  </br>
 * Date: 2021/8/4 11:18
 *
 * @author :cxy </br>
 * @version : 1.0 </br>
 */
public class PathMatchingResourcePatternResolverDemo {


    public static void main(String[] args) {
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        System.out.println(resolver.getResource("classpath:/META-INF/resource_demo.xml").exists());//true

        System.out.println(resolver.getResource("file:C:/dauadu.txt").exists()); //false

    }
}
