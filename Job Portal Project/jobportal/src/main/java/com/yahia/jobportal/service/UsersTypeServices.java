package com.yahia.jobportal.service;

import com.yahia.jobportal.entity.UsersType;
import com.yahia.jobportal.repository.UserTypeJPA;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersTypeServices {
    private final UserTypeJPA userTypeJPA;

    public UsersTypeServices(UserTypeJPA userTypeJPA){
        this.userTypeJPA=userTypeJPA;
    }
    public List<UsersType> findAll(){
        return userTypeJPA.findAll();
    }

}
