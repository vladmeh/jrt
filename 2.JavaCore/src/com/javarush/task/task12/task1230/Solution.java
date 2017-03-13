package com.javarush.task.task12.task1230;

/* 
Метод, который выводит на экран число 10
*/

public class Solution {
    public static void main(String[] args) {
        //Смотрим здесь - тип переменной Integer
        //Дописываем еще один метод с переменной Integer
        Integer i = 5;
        int x = transformValue(i);

        System.out.println(x);
    }

    public static int transformValue(int i) {
        return i * i;
    }
    public static int transformValue(Integer i) {
        return i + i;
    }
}
