package org.cxy.springdemo.dependency.inject.lazy;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class Account {

    private  People  people;

    public People getPeople() {
        return people;
    }


    /**
     * 延迟注入people
     * @param peopleObjectProvider
     */
    @Autowired
    public void setPeople(ObjectProvider<People> peopleObjectProvider) {
        this.people = peopleObjectProvider.getIfAvailable(()->{
            People people = new People();
            people.setName("unknown-account");
            return people;
        });
    }

    @Override
    public String toString() {
        return "Account{" +
                "people=" + people +
                '}';
    }
}
