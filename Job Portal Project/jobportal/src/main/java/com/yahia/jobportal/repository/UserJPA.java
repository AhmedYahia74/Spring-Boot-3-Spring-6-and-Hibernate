package com.yahia.jobportal.repository;

import com.yahia.jobportal.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserJPA extends JpaRepository<Users,Integer> {

    Optional<Users> findByEmail(String email);
}
