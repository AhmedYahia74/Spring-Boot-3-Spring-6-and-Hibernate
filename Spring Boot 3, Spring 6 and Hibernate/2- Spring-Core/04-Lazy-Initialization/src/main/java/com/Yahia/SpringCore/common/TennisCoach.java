package com.Yahia.SpringCore.common;

import jdk.jfr.Label;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
@Lazy
@Component
public class TennisCoach implements Coach{
    public TennisCoach(){
        System.out.println(getClass().getName());
    }
    @Override
    public String getDailyWorkout() {
        return "play Tennis 30 minutes";
    }
}
