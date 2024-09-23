package com.yahia.jobportal.controller;

import com.yahia.jobportal.entity.Users;
import com.yahia.jobportal.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JobsController {
    UserServices userServices;
    @Autowired
    public JobsController(UserServices userServices) {
        this.userServices = userServices;
    }

    @GetMapping("/dashboard/")
    public String FindJobs(Model model) {
        Object currentUser = userServices.getCurrentUserProfile();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            model.addAttribute("username", authentication.getName());
        }
        model.addAttribute("user", currentUser);
        return "dashboard";
    }
}
