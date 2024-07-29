package com.crud_practice_1.crud_practice_1.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud_practice_1.crud_practice_1.DAO.StudentDAO;
import com.crud_practice_1.crud_practice_1.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@RequestMapping("api")
@RestController
public class StudentApiController {

    StudentDAO studentDAO;
    EntityManager entityManager;

    public StudentApiController(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // Practicing Rest API
    @GetMapping("/students")
    public List<Student> getAllStudents() {
        TypedQuery<Student> theQuery = entityManager.createQuery("SELECT s FROM Student s", Student.class);
        List<Student> students = theQuery.getResultList();
        return students;
    }

    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable int id) {
        Student student = entityManager.find(Student.class, id);
        if(student != null){
            return student;
        }else{
            return null;
        }
    }
}
