package com.yahia.crud_demo.DAO;

import com.yahia.crud_demo.Entities.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ImplStudentDAO implements StudentDAO {
    private EntityManager entityManager;

    @Autowired
    public ImplStudentDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student readStudent(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> query = entityManager.createQuery("from Student", Student.class);
        return query.getResultList();
    }

    @Override
    public List<Student> findByLastName() {
        TypedQuery<Student> query = entityManager.createQuery("from Student where lastName=:Data", Student.class);
        query.setParameter("Data","Yahia");
        return query.getResultList();
    }

    @Override
    @Transactional
    public void updateStudent(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void delete(int id) {
        Student student=readStudent(id);
        if(student!=null)
            entityManager.remove(student);
    }
}
