package com.javarush.task.task02.task0202;

/* 
Откуда берутся Person?

В классе Person объяви следующие переменные: name типа String, age типа int, weight типа int, money типа int.
В методе main создай объект Person, занеси его ссылку в переменную person.
*/
public class Solution {
    public static void main(String[] args) {
        Person person = new Person();
    }

    public static class Person {
        String name;
        int age, weight, money;
    }
}
