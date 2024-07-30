package com.crud_practice_1.crud_practice_1.services;

import java.util.List;

import com.crud_practice_1.crud_practice_1.entity.Employee;

public interface EmployeeService {
    List<Employee> getAll();
    Employee getEmployeeById(int id);
}
