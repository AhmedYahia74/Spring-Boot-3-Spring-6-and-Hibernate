package com.yahia.securitydemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class democontroller {

    @GetMapping("/")
   public String home(){
        return "home";
    }

    @GetMapping("/Leaders")
    public String leaders(){
        return "leaders";
    }

    @GetMapping("/Systems")
    public String systems(){
        return "systems";
    }

    @GetMapping("/access-denied")
    public String accessDenied(){
        return "Can't-access";
    }
}
