package com.yahia.AOP.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class demo {

    @Pointcut("execution(public void addEmployee(..))")
    private void ex(){}
    @Before("ex()")
    public void GG(){
        System.out.println("GG");
    }
}
