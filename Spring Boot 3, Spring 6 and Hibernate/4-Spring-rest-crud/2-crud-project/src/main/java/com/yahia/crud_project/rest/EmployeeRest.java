package com.yahia.crud_project.rest;

import com.yahia.crud_project.DAO.EmployeeDAO;
import com.yahia.crud_project.entity.Employee;
import com.yahia.crud_project.service.EmployeeService;
import com.yahia.crud_project.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRest {

    EmployeeService employeeService;
    @Autowired
    public EmployeeRest(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/employee/{employeeId}")
    public Employee findById(@PathVariable int employeeId) {
        Employee employeedb = employeeService.findByID(employeeId);
        if (employeedb == null) {
            throw new RuntimeException(STR."Employee with id \{employeeId} not found");
        }
        return employeedb;
    }

    @PostMapping("/employee")
    public Employee save(@RequestBody Employee employee) {
        employee.setId(0);
        return employeeService.save(employee);
    }

    @PutMapping("/employee")
    public Employee update(@RequestBody Employee employee) {
        if (employeeService.findByID(employee.getId()) == null) {
            throw new RuntimeException("Employee Not found");
        }
        return employeeService.save(employee);
    }

    @DeleteMapping("/employee/{employeeId}")
    public String delete(@PathVariable int employeeId) {
        if (employeeService.findByID(employeeId) == null) {
            throw new RuntimeException("Employee Not found");
        }
        employeeService.delete(employeeId);
        return "Employee deleted successfully";
    }

}
