package com.javarush.task.task15.task1521;

public class Tree {
    public static int globalNumber;
    public int number;

    public Tree() {
        this.number = ++globalNumber;
    }

    public void info(Object s) {
        System.out.println(
                String.format("Дерево № %d , метод Object, параметр %s", number, s.getClass().getSimpleName())
        );
    }

    //В классе Tree должен быть реализован метод info(Number s).
    //Метод info(Number s) должен выводить на экран строку аналогичную строке из метода info(Object s),
    // заменив лишь фразу("метод Object" на "метод Number").
    public void info(Number s) {
        System.out.println(
                String.format("Дерево № %d , метод Number, параметр %s", number, s.getClass().getSimpleName())
        );
    }

    //В классе Tree должен быть реализован метод info(String s).
    //Метод info(String s) должен выводить на экран строку аналогичную строке из метода info(Object s),
    // заменив лишь фразу("метод Object" на "метод String").
    public void info(String s) {
        System.out.println(
                String.format("Дерево № %d , метод String, параметр %s", number, s.getClass().getSimpleName())
        );
    }
}
