package com.crud_practice_1.crud_practice_1.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crud_practice_1.crud_practice_1.DAO.EmployeeDAO;
import com.crud_practice_1.crud_practice_1.entity.Employee;
import com.crud_practice_1.crud_practice_1.services.EmployeeService;

import java.util.List;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@RequestMapping("/api")
@RestController
public class EmployeeController {
    EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public ResponseEntity<?> getAllEmployee() {
        return new ResponseEntity<>(employeeService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/employees/{employeeID}")
    public ResponseEntity<?> getAllEmployee(@RequestParam int employeeID) {
        return new ResponseEntity<>(employeeService.getEmployeeById(employeeID), HttpStatus.OK);
    }
    // @GetMapping("/employees")
    // public ResponseEntity<?> createEmployee(@RequestParam String first_name, @RequestParam String last_name , @RequestParam String email) {
    //     // employeeDAO.create(first_name, last_name, email);
    //     return new ResponseEntity<>("{}", HttpStatus.OK);
    // }

}