package com.javarush.task.task15.task1509;

/* 
Мужчина или женщина?
1. Изменить метод printName так, чтобы он выполнялся для man и woman.
2. Реализация метода printName должна быть одна.
*/

public class Solution {
    public static void main(String[] args) {
        Man man = new Man();
        Woman woman = new Woman();

        printName(man);
        printName(woman);
    }

    //тип переменной ставим Human
    public static void printName(Human man) {

    }

    public static class Human {

    }

    //Наследуем классы от Human
    public static class Man extends Human{

    }

    public static class Woman extends Human{

    }
}
