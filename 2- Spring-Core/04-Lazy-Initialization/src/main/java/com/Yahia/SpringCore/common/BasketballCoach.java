package com.Yahia.SpringCore.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
@Lazy
@Component
public class BasketballCoach implements Coach{
    public BasketballCoach(){
        System.out.println(getClass().getName());
    }
    @Override
    public String getDailyWorkout() {
        return "Play Basketball 30 minutes!!!";
    }
}
