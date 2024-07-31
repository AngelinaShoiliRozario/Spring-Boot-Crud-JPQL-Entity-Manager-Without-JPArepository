package com.crud_practice_1.crud_practice_1.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crud_practice_1.crud_practice_1.DAO.EmployeeDAO;
import com.crud_practice_1.crud_practice_1.entity.Employee;
import com.crud_practice_1.crud_practice_1.exceptions.NotFoundException;
import com.crud_practice_1.crud_practice_1.services.EmployeeService;

import java.util.List;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



//We should use Response and Exception handler here
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
    public ResponseEntity<?> getEmployeeById(@PathVariable int employeeID) {
        Employee employee = employeeService.getEmployeeById(employeeID);
        if(employee==null){
            throw new NotFoundException("Employee with Id "+employeeID+" not found in the database");
        }
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
    @PostMapping("/employees")
    public Employee postMethodName(@RequestBody Employee employee) {
        employee.setId(0);
        Employee dBemployee = employeeService.save(employee);
        return dBemployee;
    }
    @PutMapping("/employees")
    public ResponseEntity<?> updateEmployeeByID(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.save(employee),HttpStatus.OK);
    }
    @DeleteMapping("/employees/{employeeID}")
    public ResponseEntity<?> deleteEmployeeById(@PathVariable int employeeID) {
        Employee employee = employeeService.getEmployeeById(employeeID);
        employeeService.delete(employee);
        return new ResponseEntity<>("THe Employee has been deleted", HttpStatus.OK);
    }
}