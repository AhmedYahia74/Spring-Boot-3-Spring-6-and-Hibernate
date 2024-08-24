package com.yahia.AOP.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class demoDAO {

    public void addEmployee(){
        System.out.println("Employee Added succssesfully");
    }
}
