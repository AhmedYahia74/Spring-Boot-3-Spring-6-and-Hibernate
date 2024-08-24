package com.Yahia.SpringCore.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jdk.jfr.Label;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.logging.LoggerConfiguration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.lang.module.Configuration;

@Lazy
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TennisCoach implements Coach{
    public TennisCoach(){
        System.out.println(getClass().getName());
    }
    @Override
    public String getDailyWorkout() {
        return "play Tennis 30 minutes";
    }
    @PostConstruct
    public void postConstructor(){
        System.out.println("object is just created");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("object will destroy now");
    }
}
