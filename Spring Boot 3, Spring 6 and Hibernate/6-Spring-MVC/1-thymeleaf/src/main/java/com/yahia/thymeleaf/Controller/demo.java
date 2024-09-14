package com.yahia.thymeleaf.Controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@Controller
public class demo {


    @RequestMapping("/enter")
    String hello(@RequestParam("Name") String nam, Model model) {
//        String nam = request.getParameter("Name");
        nam = nam.toUpperCase();
        model.addAttribute("newName", STR."YOYO! \{nam}");
        return "helloworld";
    }

    @RequestMapping("/hello")
    String enter() {
        return "hello-form";
    }

}
