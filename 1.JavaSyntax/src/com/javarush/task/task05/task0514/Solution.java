package com.javarush.task.task05.task0514;

/* 
Программист создает человека
*/

public class Solution {
    public static void main(String[] args) {
        Person person = new Person();
<<<<<<< HEAD
        person.initialize("Vlad", 45);
=======
        person.initialize("Вася", 25);
>>>>>>> 6d0a2e93acded99e924263fe8dc5ddb5e35fb270
    }

    static class Person {
        private String name;
        private int age;

        public void initialize(String name, int age){
            this.name = name;
            this.age = age;
        }
    }
}
