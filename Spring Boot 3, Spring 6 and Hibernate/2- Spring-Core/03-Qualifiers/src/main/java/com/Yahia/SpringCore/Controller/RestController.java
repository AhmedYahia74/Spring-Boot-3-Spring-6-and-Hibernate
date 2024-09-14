package com.Yahia.SpringCore.Controller;


import com.Yahia.SpringCore.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {

   private Coach myCoach;

    @GetMapping("/DailyWorkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }

    @Autowired
    public void setMyCoach(@Qualifier("tennisCoach") Coach coach){
        myCoach=coach;
    }

}
