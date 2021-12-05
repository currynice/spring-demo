package org.cxy.springdemo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;


/**
 * admin 登录时记录日志
 */
//@Aspect
//@Service
public class AdminLoginAspect {




        @Before("execution(* org.cxy.springdemo.aop.AdminService.login(..)) ")
        public void logAdminLogin(JoinPoint pjp) throws Throwable {
            System.out.println("! admin login ...");
        }


}
