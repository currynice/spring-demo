package org.cxy.springdemo.dependency.lookup.lazy;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description:   </br>
 * Date: 2021/8/10 9:35
 *
 * @author :cxy </br>
 * @version : 1.0 </br>
 */
@Service
public class FooService {

        private final FooRepository repository;

//        @Autowired  4.3 后拥有构造函数隐式注入de特性
//        public FooService(FooRepository repository) {
//            this.repository = repository;
//        }


        public FooService(ObjectProvider<FooRepository> repositoryObjectProvider) {
            this.repository = repositoryObjectProvider.getIfUnique();
        }

}
