package com.javarush.task.task15.task1518;

/* 
Статики 3
*/

public class Solution {
    public static Cat cat;

    //Создаем класс Cat
    public static class Cat{
        //Создаем публичное поле name
        public String name;
    }

    //Статический блок
    static {
        // создаем объект Cat
        // и присваиваем его СУЩЕСТВУЮЩЕЙ переменной cat
        cat = new Cat();
        //Инициализируем поле name
        cat.name = "Vaska";
        //Выводим его на экран
        System.out.println(cat.name);
    }


    public static void main(String[] args) {

    }
}
