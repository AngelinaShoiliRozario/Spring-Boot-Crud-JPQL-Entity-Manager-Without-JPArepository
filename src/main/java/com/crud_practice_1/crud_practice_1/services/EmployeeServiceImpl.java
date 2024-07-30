package com.crud_practice_1.crud_practice_1.services;

import java.util.List;

import com.crud_practice_1.crud_practice_1.DAO.EmployeeDAO;
import com.crud_practice_1.crud_practice_1.entity.Employee;
import org.springframework.stereotype.Service;

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
        return employeeDAO.getAEmployeeById(id);
    }

}
