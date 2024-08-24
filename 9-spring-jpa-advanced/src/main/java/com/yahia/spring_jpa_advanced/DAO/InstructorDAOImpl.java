package com.yahia.spring_jpa_advanced.DAO;

import com.yahia.spring_jpa_advanced.entity.Course;
import com.yahia.spring_jpa_advanced.entity.Instructor;
import com.yahia.spring_jpa_advanced.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.Entity;

import java.util.Collections;
import java.util.List;

@Repository
public class InstructorDAOImpl implements InstructorDAO{

    EntityManager entityManager;
    @Autowired
    public InstructorDAOImpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }
    @Override
    @Transactional
    public void Save(Instructor instructor) {
        entityManager.persist(instructor);
    }
    @Transactional
    @Override
    public void Save(InstructorDetail instructorDetail) {
        entityManager.persist(instructorDetail);
    }

    @Override
    public Instructor findById(int id) {
        return entityManager.find(Instructor.class,id);
    }

    @Override
    @Transactional
    public void Delete(int id) {
        InstructorDetail instructorDetail=entityManager.find(InstructorDetail.class,id);
        entityManager.remove(instructorDetail);
    }

    @Override
    public List<Course> findCoursesByInstructorId(int id) {
        TypedQuery<Course> query=entityManager.createQuery("select i from Course i where instructor.id = :data",Course.class);
        query.setParameter("data",id);
        List<Course> res=query.getResultList();
        return res;
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int id) {
        TypedQuery<Instructor> query=entityManager.createQuery("select i from Instructor i join fetch i.courses where i.id = :data",Instructor.class);
        query.setParameter("data",id);
        Instructor instructor=query.getSingleResult();
        return instructor;
    }

    @Override
    @Transactional
    public void Save(Course course) {
        entityManager.persist(course);
    }

    @Override
    public Course getCourseAndReviewsById(int id) {
        TypedQuery<Course> query = entityManager.createQuery("Select c from Course c join fetch c.Reviews where c.id= :data", Course.class);
        query.setParameter("data", id);
        Course course = query.getSingleResult();
        return course;
    }
}
