package org.cxy.springdemo.aop;

import org.springframework.stereotype.Service;

@Service
public class AdminService {

    public final UserInfo adminUser = new UserInfo("202101166");

    public void login() {
        System.out.println("admin user login...");
    }


    // or spring.objenesis.ignore:true 否则代理类的属性是不会被Spring初始化
    public String getAdminPayNum(){
        return adminUser.getPayNum();
    }


}
