package com.crud_practice_1.crud_practice_1.controllers;

import com.crud_practice_1.crud_practice_1.DAO.StudentDAO;
import com.crud_practice_1.crud_practice_1.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class StudentController {
    StudentDAO studentDAO;

    public StudentController(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    // JPQL does not support Insert operations
    // using PATH VARIABLE.
    @GetMapping("/create/{name}/{age}/{marks}")
    public void createbypath(@PathVariable("marks") double marks, @PathVariable String name,
            @PathVariable("age") int age) {
        studentDAO.createEntityManager(name, age, marks);
        ;
    }

    // using REQUEST PARAM variable.
    @GetMapping("/create")
    public void createbyparam(@RequestParam("name") String name, @RequestParam("age") int age,
            @RequestParam("marks") double marks) {
        studentDAO.createEntityManager(name, age, marks);
    }

    // using PATH VARIABLE.
    @GetMapping("/read/{id}")
    public void readbypath(@PathVariable("id") int id) {
        studentDAO.readEntityManager(id);
    }

    // using REQUEST PARAM variable.
    @GetMapping("/read")
    public void readbyparam(@RequestParam("id") int id) {
        studentDAO.readEntityManager(id);
    }

    // Normal
    @GetMapping("/read_all")
    public void read() {
        studentDAO.readJPQL();
    }

    // using PATH VARIABLE.
    @GetMapping("/update/{name}/{id}")
    public void updatebypath(@PathVariable("name") String name, @PathVariable("id") int id) {
        studentDAO.updateEntityManager(name, id);
    }

    // using REQUEST PARAM variable.
    @GetMapping("/update")
    public void updatebyparam(@RequestParam("name") String name, @RequestParam("id") int id) {
        studentDAO.updateJPQL(name, id);
    }

    // using PATH VARIABLE.
    @GetMapping("/delete/{id}")
    public void deletebypath(@PathVariable("id") int id) {
        studentDAO.deleteEntityManager(id);
    }

    // using REQUEST PARAM variable.
    @GetMapping("/delete")
    public void deletebyparam(@RequestParam("id") int id) {
        studentDAO.deleteJPQL(id);
    }


    
    

}
