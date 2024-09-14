package com.yahia.spring_jpa_advanced.DAO;

import com.yahia.spring_jpa_advanced.entity.Course;
import com.yahia.spring_jpa_advanced.entity.Instructor;
import com.yahia.spring_jpa_advanced.entity.InstructorDetail;

import java.util.List;

public interface InstructorDAO {
    void Save(Instructor instructor);
    void Save(InstructorDetail instructorDetail);
    Instructor findById(int id);
    void Delete(int id);
    List<Course> findCoursesByInstructorId(int id);
    Instructor findInstructorByIdJoinFetch(int id);
    void Save(Course course);
    Course getCourseAndReviewsById(int id);
}
