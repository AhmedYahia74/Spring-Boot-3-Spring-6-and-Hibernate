package com.yahia.AOP.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class demo2 {

    @Pointcut("execution(public * com.yahia.AOP.dao.*.*(..))")
    private void ex() {
    }

    ;

    @Before("ex()")
    public void G() {
        System.out.println(5);

    }

    @Around("execution(public * com.yahia.AOP.dao.*.*())")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long a = System.currentTimeMillis();
        proceedingJoinPoint.proceed();
        long b = System.currentTimeMillis();
        System.out.println(b - a);
    }

}
