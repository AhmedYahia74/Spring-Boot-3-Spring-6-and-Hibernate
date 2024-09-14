package com.yahia.AOP.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class demo {

    @Pointcut("execution(public * addEmployee(..))")
    private void ex() {
    }
    @AfterReturning(pointcut="ex()",
    returning = "result")
    public void returning(JoinPoint joinPoint, int result){
        System.out.println(result);
    }
    @Before("ex()")
    public void GG(JoinPoint joinPoint) {
        Object[] objects = joinPoint.getArgs();
//        for (Object object : objects) {
//            System.out.println(object);
//        }
        System.out.println("GG");
    }
}
