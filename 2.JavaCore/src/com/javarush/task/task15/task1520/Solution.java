package com.javarush.task.task15.task1520;

/* 
Тренировка мозга

Найти логическую ошибку: утка(Duck) должна корректно реализовывать интерфейс Movable.
Исправьте ошибку.

Результат вывода в консоль должен быть:
flying
moving
*/

public class Solution {
    public static void main(String[] args) {
        Duck duck = new Duck();
        Util.fly(duck);
        Util.move(duck);
    }

    //Класс Duck должен реализовывать интерфейсы Movable, Flyable.
    public static class Duck implements Flyable, Movable {
        @Override
        public void doAction() {
            System.out.println("flying");
        }

        //В классе Duck должен быть реализован метод doAnotherAction.
        @Override
        public void doAnotherAction() {
            //Метод doAnotherAction() в классе Duck должен выводить на экран строку "moving".
            System.out.println("moving");
        }
    }

    public static class Util{
        static void fly(Flyable animal) {
            animal.doAction();
        }

        //Метод move должен вызывать метод doAnotherAction у переданного ему объекта.
        static void move(Movable animal) {
            //animal.doAction();
            animal.doAnotherAction();
        }
    }

    public static interface Flyable {
        void doAction();
    }

    public static interface Movable {
        void doAnotherAction();
    }
}
