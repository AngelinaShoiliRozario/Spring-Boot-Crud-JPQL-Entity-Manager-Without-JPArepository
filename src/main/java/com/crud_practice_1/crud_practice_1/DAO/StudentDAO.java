package com.crud_practice_1.crud_practice_1.DAO;

public interface StudentDAO {
    // C - Create
    void createEntityManager(String name, int age, double marks);
    void createJPQL(String name, int age, double marks);
    // R - Read
    void readEntityManager(int id);
    void readJPQL();
    // U - Update
    void updateEntityManager(String name, int id);
    void updateJPQL(String name, int id);
    // D - Delete
    void deleteEntityManager(int id);
    void deleteJPQL(int id);
}
