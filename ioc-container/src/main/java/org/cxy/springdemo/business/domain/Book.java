package org.cxy.springdemo.business.domain;

/**
 * Description:   </br>
 * Date: 2021/7/27 15:40
 *
 * @author :cxy </br>
 * @version : 1.0 </br>
 */
public class Book {

    private String name;

    private User user;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", user=" + user +
                '}';
    }
}
