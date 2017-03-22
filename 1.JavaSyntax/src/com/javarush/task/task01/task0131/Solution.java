package com.javarush.task.task01.task0131;

/* 
Полнометражная картина
Реализуй метод getMetreFromCentimetre(int centimetre).
Метод на вход принимает количество сантиметров.
Нужно сделать так, чтобы метод возвращал число полных метров в centimetre. (1 метр = 100 см).

Пример:
Метод getMetreFromCentimetre вызывается с параметром 243.

Пример вывода:
2
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getMetreFromCentimetre(243));
    }

    public static int getMetreFromCentimetre(int centimetre) {
        int m = centimetre / 100;
        return m;
    }
}