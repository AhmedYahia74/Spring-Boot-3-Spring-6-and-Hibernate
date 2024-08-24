package com.yahia.crud_project.service;

import com.yahia.crud_project.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findByID(int id);

    Employee save(Employee employee);
    void delete(int id);
}
