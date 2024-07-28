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

    // Initializing Entity Manager
    EntityManager entityManager;
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // Using ENTITY MANAGER
    //For creating one Student or many student
    @Override
    @Transactional
    public void createEntityManager(String name, int age, double marks) {
        Student student = new Student(name,age,marks);
        entityManager.persist(student);
        System.out.println("Student has been added "+ student.toString());
    }
    // X X X X Using JPQL
    //there is no insert method in jpql 
    @Override
    @Transactional
    public void createJPQL(String name, int age, double marks) {
        
    }

    // Using ENTITY MANAGER
    // For reading a Single item from the table
    @Override
    public void readEntityManager(int id) {
        Student student = entityManager.find(Student.class, id);
        System.out.println("Student Information with ID:  "+ student.toString());
    }
    // Using JPQL
    // for reading all record or records following certain condition
    @Override
    public void readJPQL() {
        TypedQuery<Student> query = entityManager.createQuery("SELECT s FROM Student s", Student.class);
        List<Student> students = query.getResultList();
        System.out.println("Read all Student Informations");
        for(Student student : students){
            System.out.println("Student Information:  "+ student.toString());
        }
    }
   
    //UPDATE Entity Manager
    // For updating a single record
    //Search By ID
    @Override
    @Transactional
    public void updateEntityManager(String name, int id) {
        Student student = entityManager.find(Student.class, id);
        if(student != null){
            student.setName(name);
            entityManager.merge(student);
        }
        System.out.println("The Name has been updated successfully. Details: "+student.toString());
    }
    //UPDATE with JPQL
    // For updating multiple record for certain condition
    //Search By Iteration
    @Override
    @Transactional
    public void updateJPQL(String name, int id) {
        System.out.println("Name "+name);
         Query query = entityManager.createQuery("UPDATE Student s SET Name = :name WHERE s.id = :id");
//        TypedQuery<Student> query = entityManager.createQuery("UPDATE Student s SET Name = :name WHERE s.id = :id", Student.class);
        query.setParameter("name", name);
        query.setParameter("id", id);
        int success  = query.executeUpdate();
        if(success > 0){
            System.out.println("The Name has been updated successfully. ");
        }else{
            System.out.println("The Name has not been updated successfully.");
        }
    }

    //DELETE : ENTITY MANAGER 
    //GOOD FOR SINGLE ITEM DELETE
    //DELETE By ID
    @Override
    @Transactional
    public void deleteEntityManager(int id) {
        Student student = entityManager.find(Student.class, id);
        if(student!=null){
            entityManager.remove(student);
        }
    }
     //DELETE : JPQL  
     //When deleting multiple records with certain condition
    //DELETE By Iteration
     @Override
     @Transactional
     public void deleteJPQL(int id) {
         Query theQuery = entityManager.createQuery("DELETE FROM Student s WHERE s.id = :id");
         theQuery.setParameter("id", id);
         theQuery.executeUpdate();
     }
 
     
}
