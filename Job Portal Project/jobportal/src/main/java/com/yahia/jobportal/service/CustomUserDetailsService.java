package com.yahia.jobportal.service;

import com.yahia.jobportal.entity.Users;
import com.yahia.jobportal.repository.UserJPA;
import com.yahia.jobportal.util.CustomeUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserJPA userJPA;

    @Autowired
    public CustomUserDetailsService(UserJPA userJPA) {
        this.userJPA = userJPA;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = userJPA.findByEmail(username).
                orElseThrow(() -> new UsernameNotFoundException("user not found"));
        return new CustomeUserDetails(users);
    }
}
