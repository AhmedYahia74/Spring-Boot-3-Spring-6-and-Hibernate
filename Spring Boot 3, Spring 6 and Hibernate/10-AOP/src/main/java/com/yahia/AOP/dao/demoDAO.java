package com.yahia.AOP.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

@Component
public class demoDAO {

    public int addEmployee(int id){
        System.out.println("Employee Added succssesfully");
        return -1;
    }
    public void around() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
    }
}
