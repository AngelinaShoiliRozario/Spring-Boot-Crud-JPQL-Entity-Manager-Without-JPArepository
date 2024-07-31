package com.crud_practice_1.crud_practice_1.services;

import java.util.List;

import com.crud_practice_1.crud_practice_1.DAO.EmployeeDAO;
import com.crud_practice_1.crud_practice_1.entity.Employee;

import jakarta.transaction.Transactional;

import org.springframework.stereotype.Service;
// We should use @Transactional inside the service layer not in the DAO implementation.

@Service
public class EmployeeServiceImpl implements EmployeeService{
    EmployeeDAO employeeDAO ;
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> getAll() {
        return employeeDAO.getAllEmployee();
    }

    @Override
    public Employee getEmployeeById(int id) {
        Employee employee = employeeDAO.getAEmployeeById(id);
        return employee;
    }

    @Override
    @Transactional
    public Employee save(Employee employee) {
       return employeeDAO.create(employee);
    }

    @Override
    @Transactional
    public void delete(Employee employee) {
        employeeDAO.deleteEmployee(employee);
    }

    

}
