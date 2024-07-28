package com.crud_practice_1.crud_practice_1.DAO;

public interface StudentDAO {
    void add(String name, int age, double marks);
    void printAll();
    void deleteEntityManager(int id);
    void deleteJPQL(int id);
    void update(String name, int id);
}
