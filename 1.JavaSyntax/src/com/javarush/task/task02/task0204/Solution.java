package com.javarush.task.task02.task0204;

/* 
О семейных отношениях

В методе main создай объект Man, сохрани ссылку на него в переменную man.
Создай также объект Woman и сохрани ссылку на него в переменную woman.
В man.wife сохрани ссылку на новосозданный объект Woman.
В woman.husband сохрани ссылку на новосозданный объект Man.
*/
public class Solution {
    public static void main(String[] args) {
        Man man = new Man();
        Woman woman = new Woman();

        man.wife = woman;
        woman.husband = man;
    }

    public static class Man {
        public int age;
        public int height;
        public Woman wife;
    }

    public static class Woman {
        public int age;
        public int height;
        public Man husband;
    }
}
