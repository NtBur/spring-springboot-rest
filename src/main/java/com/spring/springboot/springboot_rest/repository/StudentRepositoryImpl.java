package com.spring.springboot.springboot_rest.repository;

import com.spring.springboot.springboot_rest.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;


@Repository
public class StudentRepositoryImpl implements StudentRepository {
    @Autowired
    private EntityManager entityManager;
    @Override
    public List<Student> getAllStudents() {
        Query query = entityManager.createQuery("from Student");
        List<Student> students = query.getResultList();
        return students;
    }

   @Override
    public void saveStudent(Student student) {
       entityManager.merge(student);
    }

    @Override
    public Student getStudent(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public void deleteStudent(int id) {
        Query query = entityManager.createQuery("delete from Student where id=:studentsId");
        query.setParameter("studentsId", id);
        query.executeUpdate();
    }
}
