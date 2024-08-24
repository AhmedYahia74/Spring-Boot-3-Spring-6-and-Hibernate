package com.yahia.rest_crud.RestController;

import com.yahia.rest_crud.entities.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class studentRestController {
    List<Student> theStudents;

    @PostConstruct
    private void loadData() {
        theStudents = new ArrayList<>();
        theStudents.add(new Student("ahmed", "yahia"));
        theStudents.add(new Student("hossam", "hassan"));
        theStudents.add(new Student("mostafa", "saad"));
    }

    @GetMapping("/students")
    List<Student> students() {
        return theStudents;
    }

    @GetMapping("/students/{studentId}")
    Student student(@PathVariable int studentId) {
        if (studentId >= theStudents.size() || studentId < 0) {
            throw new StudentNotFoundException(STR."id \{studentId} Not Correct");
        }
        return theStudents.get(studentId);
    }


}
