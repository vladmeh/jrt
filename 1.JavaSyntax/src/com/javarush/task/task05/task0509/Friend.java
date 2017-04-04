package com.javarush.task.task05.task0509;

/* 
Создать класс Friend

Создать класс Friend (друг) с тремя инициализаторами (тремя методами initialize):
— Имя
— Имя, возраст
— Имя, возраст, пол

Примечание:
Имя(String), возраст(int), пол(char).


Требования:
1. Программа не должна считывать данные с клавиатуры.
2. У класса Friend должна быть переменная name с типом String.
3. У класса Friend должна быть переменная age с типом int.
4. У класса Friend должна быть переменная sex с типом char.
5. У класса должен быть метод initialize, принимающий в качестве параметра имя и инициализирующий соответствующую переменную класса.
6. У класса должен быть метод initialize, принимающий в качестве параметров имя, возраст и инициализирующий соответствующие переменные класса.
7. У класса должен быть метод initialize, принимающий в качестве параметров имя, возраст, пол и инициализирующий соответствующие переменные класса.
*/

public class Friend {
    private String name;
    private int age;
    private char sex;

    public void initialize(String name){
        this.name = name;
    }

    public void initialize(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void initialize(String name, int age, char sex){
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public static void main(String[] args) {

    }
}
