package org.cxy.springdemo.dependency.inject.lazy;


import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;

public class PeopleService {

    @Autowired
    private ObjectProvider<People> peopleObjectProvider;


    public void test(){
       System.out.println( peopleObjectProvider.getIfAvailable());
    }
}
