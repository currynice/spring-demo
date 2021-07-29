package org.cxy.springdemo.mybeans.factory.test.bean;


public class UserService {

    private String id;

    private UserDao userDao;


    public UserService(){
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void queryUserInfo() {
        System.out.println("查询用户信息：" + userDao.queryUserName(id));
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("");
        sb.append("").append(id);
        return sb.toString();
    }


}
