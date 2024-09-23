package com.yahia.jobportal.controller;

import com.yahia.jobportal.entity.RecruiterProfile;
import com.yahia.jobportal.entity.Users;
import com.yahia.jobportal.repository.RecruiterProfileJPA;
import com.yahia.jobportal.repository.UserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RecruiterProfileController {
    private final UserJPA userJPA;
    private final RecruiterProfileJPA recruiterProfileJPA;

    @Autowired
    public RecruiterProfileController(UserJPA userJPA, RecruiterProfileJPA recruiterProfileJPA) {
        this.userJPA = userJPA;
        this.recruiterProfileJPA = recruiterProfileJPA;
    }

    @GetMapping("/recruiter-profile/")
    public String profile(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String email = authentication.getName();
            Users users = userJPA.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User not found"));
            RecruiterProfile recruiterProfile = recruiterProfileJPA.getById(users.getUserId());
            model.addAttribute("profile", recruiterProfile);
        }
        return "recruiter_profile";
    }
}
