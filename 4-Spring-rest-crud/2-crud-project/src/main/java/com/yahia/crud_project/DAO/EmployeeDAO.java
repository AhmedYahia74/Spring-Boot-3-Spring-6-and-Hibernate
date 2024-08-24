package com.yahia.crud_project.DAO;

import com.yahia.crud_project.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
    Employee findById(int id);
    Employee save(Employee employee);
    void Delete(int id);

}
