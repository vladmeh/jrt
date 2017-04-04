package com.javarush.task.task05.task0511;

/* 
Создать класс Dog

Создать класс Dog (собака) с тремя инициализаторами:
— Имя
— Имя, рост
— Имя, рост, цвет


Требования:
1. Программа не должна считывать данные с клавиатуры.
2. У класса Dog должна быть переменная name с типом String.
3. У класса Dog должна быть переменная height с типом int.
4. У класса Dog должна быть переменная color с типом String.
5. У класса должен быть метод initialize, принимающий в качестве параметра имя и инициализирующий соответствующую переменную класса.
6. У класса должен быть метод initialize, принимающий в качестве параметров имя, рост и инициализирующий соответствующие переменные класса.
7. У класса должен быть метод initialize, принимающий в качестве параметров имя, рост, цвет и инициализирующий соответствующие переменные класса.
*/

public class Dog {
    private String name, color;
    private int height;

    public void initialize(String name){
        this.name = name;
    }

    public void initialize(String name, int height){
        this.name = name;
        this.height = height;
    }

    public void initialize(String name, int height, String color){
        this.name = name;
        this.height = height;
        this.color = color;
    }

    public static void main(String[] args) {

    }
}
