package com.Yahia.SpringCore.Controller;


import com.Yahia.SpringCore.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    Coach myCoach;

    @Autowired
    public RestController(Coach coach) {
        myCoach = coach;
    }

    @GetMapping("/DailyWorkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }


}
