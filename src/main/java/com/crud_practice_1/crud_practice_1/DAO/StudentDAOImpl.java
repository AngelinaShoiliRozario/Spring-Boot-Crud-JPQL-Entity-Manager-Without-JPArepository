package com.crud_practice_1.crud_practice_1.DAO;

import com.crud_practice_1.crud_practice_1.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class StudentDAOImpl implements StudentDAO{


    EntityManager entityManager;
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // Using ENTITY MANAGER
    @Override
    @Transactional
    public void createEntityManager(String name, int age, double marks) {
        Student student = new Student(name,age,marks);
        entityManager.persist(student);
        System.out.println("Student has been added "+ student.toString());
    }
    // Using JPQL
    @Override
    @Transactional
    public void createJPQL(String name, int age, double marks) {
        //there is no insert method in jpql
    }
    
    @Override
    public void add(String name, int age, double marks) {
        Student s1 = new Student(name, age, marks);
        entityManager.persist(s1);
        System.out.println("Successfully added the student details "+ s1.toString());
    }

    @Override
    public void printAll() {
        // Create a query to select all students
        TypedQuery<Student> query = entityManager.createQuery("SELECT s FROM Student s", Student.class);
        // Execute the query and get the result list
        List<Student> studentList = query.getResultList();
        for(Student student : studentList){
            System.out.println(student.toString());
        }
    }
    //DELETE : JPQL  //When deleting with condition or complex queryies
    @Override
    @Transactional
    public void deleteJPQL(int id) {
        Query theQuery = entityManager.createQuery("DELETE FROM Student s WHERE s.id = :id");
        theQuery.setParameter("id", id);
        theQuery.executeUpdate();
    }

    //DELETE : ENTITY MANAGER //GOOD FOR SINGLE ITEM DELETE
    @Override
    @Transactional
    public void deleteEntityManager(int id) {
        Student student = entityManager.find(Student.class, id);
        if(student!=null){
            entityManager.remove(student);
        }
    }

    @Override
    public void update(String name, int id) {

    }

    

}
