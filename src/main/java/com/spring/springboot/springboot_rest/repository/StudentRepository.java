package com.spring.springboot.springboot_rest.repository;


import com.spring.springboot.springboot_rest.entity.Student;

import java.util.List;

public interface StudentRepository {
    List<Student> getAllStudents();

   void saveStudent(Student student);

    Student getStudent(int id);

    void deleteStudent(int id);
}
