package com.javarush.task.task05.task0510;

/* 
Кошкоинициация
*/

public class Cat {
    private String name, color, address;
    private int weight, age;

    public void initialize(String name){
        this.name = name;
        this.weight = 5;
        this.age = 2;
        this.color = "grey";
    }

    public void initialize(String name, int weight, int age){
        this.name = name;
        this.weight = weight;
        this.age = age;
        this.color = "gray";
    }

    public void initialize(String name, int age){
        this.name = name;
        this.weight = 5;
        this.age = age;
        this.color = "gray";
    }

    public void initialize(int weight, String color){
        this.weight = weight;
        this.color = color;
        this.age = 2;
    }

    public void initialize(int weight, String color, String address){
        this.weight = weight;
        this.color = color;
        this.address = address;
        this.age = 2;
    }

    public static void main(String[] args) {

    }
}
