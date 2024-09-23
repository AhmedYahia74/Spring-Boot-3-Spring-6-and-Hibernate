package com.yahia.jobportal.controller;

import com.yahia.jobportal.entity.Users;
import com.yahia.jobportal.entity.UsersType;
import com.yahia.jobportal.service.UserServices;
import com.yahia.jobportal.service.UsersTypeServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {
    UsersTypeServices usersTypeServices;
    UserServices userServices;
    @Autowired
    public UserController(UsersTypeServices usersTypeServices,UserServices userServices){
        this.usersTypeServices=usersTypeServices;
        this.userServices=userServices;
    }
    @GetMapping("/register")
    public String register(Model model){
        List<UsersType> usersTypes = usersTypeServices.findAll();
        model.addAttribute("getAllTypes", usersTypes);
        model.addAttribute("user",new Users());
        return "register";
    }
    @PostMapping("/register/new")
    public String test(@Valid Users users, Model model){
        if(userServices.findByEmila(users.getEmail()).isPresent()){
            model.addAttribute("error", "Email already registered,try to login or register with other email.");
            List<UsersType> usersTypes = usersTypeServices.findAll();
            model.addAttribute("getAllTypes", usersTypes);
            model.addAttribute("user",new Users());
            return "register";
        }
        userServices.save(users);
        return "redirect:/login";
    }
}
