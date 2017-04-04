package com.javarush.task.task05.task0515;

/* 
Инициализация объектов

Изучи внимательно класс Person.
Исправь класс так, чтобы только один метод initialize инициализировал все переменные класса Person.


Требования:
1. Программа не должна считывать данные с клавиатуры.
2. У класса Person должно быть 5 переменных.
3. У класса должен быть один метод initialize.
4. Метод initialize должен иметь пять параметров.
*/

public class Person {
    String name;
    char sex;
    int money;
    int weight;
    double size;

    public void initialize(String name, int money, char sex, int weight, double size) {
        this.name = name;
        this.money = money;
        this.sex = sex;
        this.weight = weight;
        this.size = size;
    }

    public static void main(String[] args) {

    }
}
