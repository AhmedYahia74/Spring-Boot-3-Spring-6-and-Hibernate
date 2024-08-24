package com.Yahia.SpringCore.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "play Tennis 30 minutes";
    }
}
