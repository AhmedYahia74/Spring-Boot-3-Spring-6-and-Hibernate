package com.yahia.spring_jpa_advanced;

import com.yahia.spring_jpa_advanced.DAO.InstructorDAO;
import com.yahia.spring_jpa_advanced.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringJpaAdvancedApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaAdvancedApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(InstructorDAO instructorDAO){
		return runner -> {
//			createInstructor(instructorDAO);
//			DeleteInstructor(instructorDAO);

//			CreateInstrucotr2(instructorDAO);

//			Find(instructorDAO);

//		    createCourse(instructorDAO);

//			findCourse(instructorDAO);

			createCourse(instructorDAO);
		};
	}

	private void findCourse(InstructorDAO instructorDAO) {
		Course course=instructorDAO.getCourseAndReviewsById(10);

		System.out.println(course);
	}

	private void createCourse(InstructorDAO instructorDAO) {
		Course course = new Course("English");

		course.addReview(new Review("GG"));
		course.addReview(new Review("it's a shit course"));
		course.addStudent(new Student("ahmed","yahia","ahmedyahia@gmail.com"));
		instructorDAO.Save(course);
	}

	private void Find(InstructorDAO instructorDAO) {
		Instructor instructor=instructorDAO.findInstructorByIdJoinFetch(1);
		System.out.println(instructor.getCourses().get(0));
	}

	private void CreateInstrucotr2(InstructorDAO instructorDAO) {
		InstructorDetail instructorDetail = new InstructorDetail("AhmedYahia", "ay 7aga");
		Instructor instructor = new Instructor("ahmed", "yahia", "ahmedyahia@gmail.com", instructorDetail);
		Course a = new Course("arabic");
		instructor.add(a);
		instructorDAO.Save(instructor);

	}

	private void DeleteInstructor(InstructorDAO instructorDAO) {
		instructorDAO.Delete(2);
	}

	private void createInstructor(InstructorDAO instructorDAO) {
		InstructorDetail instructorDetail= new InstructorDetail("AhmedYahia","ay 7aga");
		Instructor instructor=new Instructor("ahmed", "yahia", "ahmedyahia@gmail.com",instructorDetail);
		instructorDAO.Save(instructorDetail);
	}
}
