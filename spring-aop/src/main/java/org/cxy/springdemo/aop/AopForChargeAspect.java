package org.cxy.springdemo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;


/**
 * charge接口 aop
 *
 * 同⼀个切⾯中，不同类型的增强⽅法被调⽤的顺序依次为
 * Around.class, Before.class, After.class, AfterReturning.class, AfterThrowing.class
 *
 *
 * 同⼀个target存在多个同类型增强时，其执⾏顺序和当前增强target的名称排序有关
 */
@Aspect
@Service
public class AopForChargeAspect {


     @Before("execution(* org.cxy.springdemo.aop.ElectricService.charge()) ")
        public void checkAuthority(JoinPoint pjp) throws Throwable {
        System.out.println("validating user authority");
    }


        @Around("execution(* org.cxy.springdemo.aop.ElectricService.doCharge()) ")
        public void recordDoChargePerformance(ProceedingJoinPoint joinPoint) throws Throwable {
            long start = System.currentTimeMillis();
            joinPoint.proceed();
            long end = System.currentTimeMillis();
            System.out.println("docharge method time cost（ms）: " + (end - start));
        }


}
