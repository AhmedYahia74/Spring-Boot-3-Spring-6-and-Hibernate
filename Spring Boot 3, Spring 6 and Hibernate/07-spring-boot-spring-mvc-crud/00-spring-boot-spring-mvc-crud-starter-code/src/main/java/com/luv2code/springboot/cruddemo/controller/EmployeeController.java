package com.luv2code.springboot.cruddemo.controller;

import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {
    EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    String findALL(Model model) {
        model.addAttribute("employees", employeeService.findAll());
        return "Employees-List";
    }

    @GetMapping("/showFormForAdd")
    String showform(Model model) {
        model.addAttribute("employee", new Employee());
        return "add-employee";
    }
    @GetMapping("/showFormForUpdate")
    String showform(Model model, @RequestParam("employeeId") int employeeId ) {
        Employee employee=employeeService.findById(employeeId);
        model.addAttribute("employee",employee);
        return "update-employee";
    }
    @GetMapping("/Delete")
    String delete(Model model, @RequestParam("employeeId") int employeeId ) {
        employeeService.deleteById(employeeId);
        return "redirect:/list";
    }

    @PostMapping("/save")
    String save(@ModelAttribute("employee") Employee employee) {
       employeeService.save(employee);
        return "redirect:/list";
    }

}
