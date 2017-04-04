package com.javarush.task.task05.task0508;

/* 
Геттеры и сеттеры для класса Person

Создать class Person. У человека должно быть имя String name, возраст int age, пол char sex.
Создайте геттеры и сеттеры для всех переменных класса Person.


Требования:
1. Программа не должна считывать данные с клавиатуры.
2. У класса Person должна быть переменная name с типом String.
3. У класса Person должна быть переменная age с типом int.
4. У класса Person должна быть переменная sex с типом char.
5. У класса должен сеттер для переменной name.
6. У класса должен геттер для переменной name.
7. У класса должен сеттер для переменной age.
8. У класса должен геттер для переменной age.
9. У класса должен сеттер для переменной sex.
10. У класса должен геттер для переменной sex.
*/

public class Person {
    private String name;
    private int age;
    private char sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public static void main(String[] args) {

    }
}
