package org.cxy.springdemo.ioc.container.repository;


import org.cxy.springdemo.ioc.container.domain.User;

import java.util.Collection;
import java.util.List;

/**
 * 用户信息仓库
 */
public class UserRepository {

    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
