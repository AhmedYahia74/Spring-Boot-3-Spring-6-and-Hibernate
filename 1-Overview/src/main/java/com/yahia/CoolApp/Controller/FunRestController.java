package com.yahia.CoolApp.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    @GetMapping("/")
    public String SayHello(){
        return "Hello World!";
    }
    @GetMapping("/workout")
    public String DailyWorkOut(){
        return "Damn";
    }
    @Value("${team}")
    String teamName;
    @GetMapping("/teamname")
    public String getTeamName(){
        return teamName;
    }

}
