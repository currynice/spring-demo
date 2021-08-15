package org.cxy.springdemo.dependency.inject.lazy;

public class Family {

    private  People  people;

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }

    @Override
    public String toString() {
        return "Family{" +
                "people=" + people +
                '}';
    }
}
