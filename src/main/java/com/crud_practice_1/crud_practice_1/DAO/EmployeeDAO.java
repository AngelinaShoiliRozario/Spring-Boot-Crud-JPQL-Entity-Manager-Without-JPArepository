package com.crud_practice_1.crud_practice_1.DAO;

import com.crud_practice_1.crud_practice_1.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    // create employee
    void create(String firstName, String lastName, String email);
    // return list of employee
    List<Employee> getAllEmployee();
    // return single employee
    Employee getAEmployeeById(int id);
    // update single employee
    void editAEmployeeById(int id, String newFirstName);
    // delete single employee
    void deleteAEmployeeById(int id);
}
