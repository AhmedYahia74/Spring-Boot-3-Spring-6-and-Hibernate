package com.yahia.crud_project.DAO;

import com.yahia.crud_project.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@RepositoryRestResource(path = "member")
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}
