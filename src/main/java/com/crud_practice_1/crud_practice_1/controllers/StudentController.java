package com.crud_practice_1.crud_practice_1.controllers;

import com.crud_practice_1.crud_practice_1.DAO.StudentDAO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    StudentDAO studentDAO;
    @Autowired
    public StudentController(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }
    @Transactional
    @GetMapping("/add_student")
    public void SaveStudent(@RequestParam("name") String name, @RequestParam("age") int age, @RequestParam("marks") double marks){
        studentDAO.add(name, age, marks);
    }


    @GetMapping("/students")
    public void Students(){
        studentDAO.printAll();
    }

    // using PATH VARIABLE.
    @GetMapping("/delete/{id}")
    public void deletebypath(@PathVariable("id") int id){
        studentDAO.deleteEntityManager(id);
    }

    // using REQUEST PARAM variable.
    @GetMapping("/delete")
    public void deletebyparam(@RequestParam("id") int id){
        studentDAO.deleteJPQL(id);
    }

    // JPQL does not support Insert operations
    // using PATH VARIABLE.
    @GetMapping("/create/{name}/{age}/{marks}")
    public void createbypath(@PathVariable("marks") double marks, @PathVariable("name") String name, @PathVariable("age") int age){
        studentDAO.createEntityManager(name, age, marks);;
    }

    // using REQUEST PARAM variable.
    @GetMapping("/create")
    public void createbyparam(@RequestParam("name") String name, @RequestParam("age") int age, @RequestParam("marks") double marks){
        studentDAO.createEntityManager(name, age, marks);
    }




}
