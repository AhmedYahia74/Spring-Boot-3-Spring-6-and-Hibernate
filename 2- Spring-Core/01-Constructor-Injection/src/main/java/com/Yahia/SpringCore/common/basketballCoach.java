package com.Yahia.SpringCore.common;

import org.springframework.stereotype.Component;

@Component
public class basketballCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Play Basketball 30 minutes";
    }
}
