package com.yahia.thymeleaf.Controller;

import com.yahia.thymeleaf.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {
    @Value("${Countries}")
    List<String> countries=new ArrayList<>();

    @Value("${Languages}")
    List<String> languages=new ArrayList<>();
    @GetMapping("/ShowStudentForm")
    public String StudentForm(Model themodel) {
        Student student = new Student();
        themodel.addAttribute("student", student);
        themodel.addAttribute("countries", countries);
        themodel.addAttribute("languages", languages);
        return "Show-Student-Form";
    }

    @GetMapping("/ConfirmStudent")
    public String Confirm(@ModelAttribute("student") Student theStudent){

        return "confirm-form";
    }

}
