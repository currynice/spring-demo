package org.cxy.springdemo.ioc.container.annotation;

import org.cxy.springdemo.business.domain.A;
import org.cxy.springdemo.business.domain.B;
import org.cxy.springdemo.business.domain.Book;
import org.cxy.springdemo.business.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;

/**
 * Description: 相较于 xml驱动，注解驱动需要配置类。
 * Date: 2021/7/28 9:41
 *
 * @author :cxy </br>
 * @version : 1.0 </br>
 */
@Configuration
//结合xml驱动
@ImportResource(value = "classpath:META-INF/dependency-injection-context.xml")
@ComponentScan("org.cxy.springdemo")
@PropertySource("classpath:config.properties")
public class QuickStartConfiguration {


//    <bean id="user" class="org.cxy.springdemo.business.domain.User"/>

    @Bean(name = "cxy")
    public User cxy() {
        User cxy = new User();
        cxy.setId("1");
        cxy.setName("cxy");
        return cxy;
    }

//     <bean id="book" class="org.cxy.springdemo.business.domain.Book">
//        <property name="name" value="test-book"/>
//        <!-- ref引用上面的 user对象 -->
//        <property name="user" ref="user"/>
//    </bean>

    @Bean(name = "book")
    public Book book() {
        Book book = new Book();
        book.setName("test-book");
        book.setUser(cxy());
        return book;
    }


    @Bean
//    @Autowired
    public A a(B b){
        A a = new A();
        a.setB(b);
        return a;
    }
}
