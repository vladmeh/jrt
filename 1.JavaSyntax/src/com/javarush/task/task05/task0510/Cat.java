package com.javarush.task.task05.task0510;

/* 
Кошкоинициация

Создать класс Cat (кот) с пятью инициализаторами:
— Имя,
— Имя, вес, возраст
— Имя, возраст (вес стандартный)
— вес, цвет (имя, адрес и возраст неизвестны, это бездомный кот)
— вес, цвет, адрес (чужой домашний кот)

Задача инициализатора – сделать объект валидным.
Например, если вес неизвестен, то нужно указать какой-нибудь средний вес.
Кот не может ничего не весить.
То же касательно возраста.
А вот имени может и не быть (null).
То же касается адреса: null.


Требования:
1. Программа не должна считывать данные с клавиатуры.
2. У класса Cat должна быть переменная name с типом String.
3. У класса Cat должна быть переменная age с типом int.
4. У класса Cat должна быть переменная weight с типом int.
5. У класса Cat должна быть переменная address с типом String.
6. У класса Cat должна быть переменная color с типом String.
7. У класса должен быть метод initialize, принимающий в качестве параметра имя, но инициализирующий все переменные класса, кроме адреса.
8. У класса должен быть метод initialize, принимающий в качестве параметров имя, вес, возраст и инициализирующий все переменные класса, кроме адреса.
9. У класса должен быть метод initialize, принимающий в качестве параметров имя, возраст и инициализирующий все переменные класса, кроме адреса.
10. У класса должен быть метод initialize, принимающий в качестве параметров вес, цвет и инициализирующий все переменные класса, кроме имени и адреса.
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
