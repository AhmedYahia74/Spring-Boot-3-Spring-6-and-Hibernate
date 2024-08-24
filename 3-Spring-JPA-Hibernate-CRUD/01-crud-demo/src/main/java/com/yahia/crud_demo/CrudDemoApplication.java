package com.yahia.crud_demo;

import com.yahia.crud_demo.DAO.ImplStudentDAO;
import com.yahia.crud_demo.DAO.StudentDAO;
import com.yahia.crud_demo.Entities.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner CommandLineRunner(StudentDAO studentDAO){
		return runner-> {
			Delete(studentDAO);
		};
	}

	private void Delete(StudentDAO studentDAO) {
		int id=1;

		studentDAO.delete(id);
		ReadAll(studentDAO);
	}

	private void Update(StudentDAO studentDAO) {
		int id=1;
		Student curr=studentDAO.readStudent(id);
		curr.setEmail("gg@gmail.com");
		studentDAO.updateStudent(curr);
		System.out.println(studentDAO.readStudent(id));
	}

	private void FindByLastName(StudentDAO studentDAO) {
		List<Student> theStudents=studentDAO.findByLastName();
		for(Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void ReadAll(StudentDAO studentDAO) {
		List<Student> theStudents=studentDAO.findAll();
		for(Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void ReadStudent(StudentDAO studentDAO) {
		System.out.println(studentDAO.readStudent(2));
	}

	private void CreateStudent(StudentDAO studentDAO) {

		Student student=new Student("ahmed","yahia","ahmedyahiaswe@gmail.com");
		studentDAO.save(student);
		System.out.println(student.getId());
	}

}
