package com.crud_practice_1.crud_practice_1.DAO;

public interface StudentDAO {
    void createEntityManager(String name, int age, double marks);
    void createJPQL(String name, int age, double marks);
    void add(String name, int age, double marks);
    void printAll();
    void deleteEntityManager(int id);
    void deleteJPQL(int id);
    void update(String name, int id);
}
