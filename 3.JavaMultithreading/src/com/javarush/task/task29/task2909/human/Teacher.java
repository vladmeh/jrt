package com.javarush.task.task29.task2909.human;


public class Teacher extends Human {

    private int numberOfStudents;
    private String university;

    public Teacher(String name, int age, int numberOfStudents) {
        super(name, age);
        this.name = name;
        this.age = age;
        this.numberOfStudents = numberOfStudents;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public void printData() {
        System.out.println("Преподаватель: " + name);
    }
}