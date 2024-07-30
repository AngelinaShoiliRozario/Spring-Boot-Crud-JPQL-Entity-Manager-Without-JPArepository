package com.crud_practice_1.crud_practice_1.DAO;

import com.crud_practice_1.crud_practice_1.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAOImpl implements  EmployeeDAO{
    EntityManager entityManager;

    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void create(String firstName, String lastName, String email) {
        Employee employee = new Employee(firstName, lastName, email);
        entityManager.persist(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        TypedQuery<Employee> query = entityManager.createQuery("SELECT e FROM Employee e", Employee.class);
        List<Employee> employees = query.getResultList();
        return employees;
    }

    @Override
    public Employee getAEmployeeById(int id) {
        Employee employee = entityManager.find(Employee.class, id);
        return employee;
    }

    @Override
    public void deleteAEmployeeById(int id) {
        Employee employee = entityManager.find(Employee.class, id);
        entityManager.remove(employee);        
    }

    @Override
    public void editAEmployeeById(int id, String newFirstName) {
        Employee employee = entityManager.find(Employee.class, id);
        employee.setFirstName(newFirstName);
        entityManager.merge(employee);
    }

    
}
