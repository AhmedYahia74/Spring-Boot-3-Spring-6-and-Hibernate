package com.yahia.crud_demo.DAO;

import com.yahia.crud_demo.Entities.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);
    Student readStudent(Integer id);
    List<Student> findAll();
    List<Student> findByLastName();
    void updateStudent(Student student);
    void delete(int id);

}
