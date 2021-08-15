package org.cxy.springdemo.dependency.inject.lazy;


import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Book {
    private  People  author;

    public People getAuthor() {
        return author;
    }

    public void setAuthor(People author) {
        this.author = author;
    }

    public Book() {
    }


    @Autowired
    public Book(ObjectProvider<People> peopleObjectProvider) {
        this.author  = peopleObjectProvider.getIfAvailable(()->{
            People people = new People();
            people.setName("unknown-author");
            return people;
        });
    }

    @Override
    public String toString() {
        return "Book{" +
                "author=" + author +
                '}';
    }
}
