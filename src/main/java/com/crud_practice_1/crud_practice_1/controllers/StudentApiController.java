package com.crud_practice_1.crud_practice_1.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud_practice_1.crud_practice_1.DAO.StudentDAO;
import com.crud_practice_1.crud_practice_1.entity.Student;
import com.crud_practice_1.crud_practice_1.entity.StudentNotFound;
import com.crud_practice_1.crud_practice_1.exceptions.StudentNotFoundException;

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
    public ResponseEntity<?> getStudentById(@PathVariable int id) {
        Student student = entityManager.find(Student.class, id);
        if(student != null){
            return new ResponseEntity<>(student, HttpStatus.OK);
        }else{
            //throwed a error
            throw new StudentNotFoundException("Student Not Found On id- "+id);
        }
    }

    @ExceptionHandler
    public ResponseEntity<?> exceptionHandler(StudentNotFoundException exc){
        StudentNotFound studentNotFound = new StudentNotFound(HttpStatus.NOT_FOUND.value(),exc.getMessage(),23322);
        return new ResponseEntity<>(studentNotFound,HttpStatus.NOT_FOUND);
    }
}
