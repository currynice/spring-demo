package org.cxy.springdemo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;


/**
 * 记录支付接口调用耗时
 */
//@Aspect
//@Service
public class TimeCountForPayAspect {




        @Around("execution(* org.cxy.springdemo.aop.ElectricService.pay()) ")
        public void recordPayPerformance(ProceedingJoinPoint joinPoint) throws Throwable {
            long start = System.currentTimeMillis();
            joinPoint.proceed();
            long end = System.currentTimeMillis();
            System.out.println("Pay method time cost（ms）: " + (end - start));
        }


}
