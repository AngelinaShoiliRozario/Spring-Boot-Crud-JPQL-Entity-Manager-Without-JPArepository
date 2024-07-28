package com.crud_practice_1.crud_practice_1.entity;

import jakarta.persistence.*;

@Entity
@Table(name="students")
public class Student {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long Id;

    @Column(name="name")
    private String Name;

    @Column(name="age")
    private Integer Age;

    @Column(name="marks")
    private Double Marks;

    public Student() {
    }

    public Student(String name, Integer age, Double marks) {
        Name = name;
        Age = age;
        Marks = marks;
    }

    public String getName() {
        return Name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", Age=" + Age +
                ", Marks=" + Marks +
                '}';
    }

    public void setName(String name) {
        Name = name;
    }

    public Number getAge() {
        return Age;
    }

    public void setAge(Integer age) {
        Age = age;
    }

    public Double getMarks() {
        return Marks;
    }

    public void setMarks(Double marks) {
        Marks = marks;
    }
}
