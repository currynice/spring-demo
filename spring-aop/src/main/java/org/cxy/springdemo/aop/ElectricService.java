package org.cxy.springdemo.aop;

import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ElectricService {

    @Autowired
    private AdminService adminService;


    public void charge() throws Exception{
        ElectricService electric = ((ElectricService) AopContext.currentProxy());

        electric.doCharge();
    }

    public void doCharge() throws Exception {
        ElectricService electric = ((ElectricService) AopContext.currentProxy());

        System.out.println("Electric charging ...");
//        this.pay();
        electric.pay();
    }



    public void pay() throws Exception {
        adminService.login();
        String payNum = adminService.getAdminPayNum();
        System.out.println("User pay num : " + payNum);
        System.out.println("Pay with alipay ...");
        Thread.sleep(1000);
    }

}
