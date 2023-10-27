package com.spring.springboot.springboot_rest.controller;

import com.spring.springboot.springboot_rest.entity.Student;
import com.spring.springboot.springboot_rest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

   @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable int id){
        return studentService.getStudent(id);
    }
    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student){
        studentService.saveStudent(student);
        return student;
    }
    @PutMapping("/students")
    public Student updateStudent(@RequestBody Student student){
        studentService.saveStudent(student);
        return student;
    }
    @DeleteMapping("/students/{id}")
    public String deleteStudent(@PathVariable int id){
        studentService.deleteStudent(id);
        return "Student with id "+ id + " was deleted";
    }

}
