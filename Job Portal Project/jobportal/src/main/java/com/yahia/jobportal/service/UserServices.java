package com.yahia.jobportal.service;

import com.yahia.jobportal.entity.JobSeekerProfile;
import com.yahia.jobportal.entity.RecruiterProfile;
import com.yahia.jobportal.entity.Users;
import com.yahia.jobportal.repository.JobSeekerProfileJPA;
import com.yahia.jobportal.repository.RecruiterProfileJPA;
import com.yahia.jobportal.repository.UserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServices {
   private final UserJPA userJPA;
    private final RecruiterProfileJPA recruiterProfileJPA;
    private final JobSeekerProfileJPA jobSeekerProfileJPA;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    public UserServices(UserJPA userJPA, RecruiterProfileJPA recruiterProfileJPA, JobSeekerProfileJPA jobSeekerProfileJPA, PasswordEncoder passwordEncoder){
        this.userJPA=userJPA;
        this.recruiterProfileJPA = recruiterProfileJPA;
        this.jobSeekerProfileJPA = jobSeekerProfileJPA;
        this.passwordEncoder = passwordEncoder;
    }
    public Optional<Users> findByEmila(String email){
        return userJPA.findByEmail(email);
    }
    public void save(Users users){

        String EncodedPassword=passwordEncoder.encode(users.getPassword());
        users.setPassword(EncodedPassword);
        users.setActive(true);
        userJPA.save(users);
        if(users.getUserTypeId().getUserTypeId()==1){
            recruiterProfileJPA.save(new RecruiterProfile(users));
        }
        else{
            jobSeekerProfileJPA.save(new JobSeekerProfile(users));
        }
    }

    public Object getCurrentUserProfile() {

        Authentication principal = SecurityContextHolder.getContext().getAuthentication();
        if(!(principal instanceof AnonymousAuthenticationToken)){
            String email=principal.getName();
            Users users=userJPA.findByEmail(email).orElseThrow(()-> new UsernameNotFoundException("Could not found " + "user"));
            if (principal.getAuthorities().contains(new SimpleGrantedAuthority("Recruiter"))){
                return recruiterProfileJPA.findById(users.getUserId()).orElse(new RecruiterProfile(users));
            }
            else
                return jobSeekerProfileJPA.findById(users.getUserId()).orElse(new JobSeekerProfile(users));
        }

        return null;
    }
}
