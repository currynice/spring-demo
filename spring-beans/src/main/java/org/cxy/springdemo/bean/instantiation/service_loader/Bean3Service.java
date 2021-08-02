package org.cxy.springdemo.bean.instantiation.service_loader;

import org.cxy.springdemo.bean.instantiation.instanceFactory.Bean2;

public interface Bean3Service {

    default Bean3 getBean3(){
        return new Bean3();
    }

}
