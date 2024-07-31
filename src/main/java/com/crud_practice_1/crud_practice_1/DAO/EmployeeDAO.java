package com.crud_practice_1.crud_practice_1.DAO;

import com.crud_practice_1.crud_practice_1.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    // create employee
    // update single employee
    Employee create(Employee employee);
    // return list of employee
    List<Employee> getAllEmployee();
    // return single employee
    Employee getAEmployeeById(int id);
    // delete single employee
    void deleteEmployee(Employee employee);
}
