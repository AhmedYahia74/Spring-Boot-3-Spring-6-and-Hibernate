package com.yahia.jobportal.repository;


import com.yahia.jobportal.entity.UsersType;
import org.hibernate.usertype.UserType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTypeJPA extends JpaRepository<UsersType,Integer> {
}
