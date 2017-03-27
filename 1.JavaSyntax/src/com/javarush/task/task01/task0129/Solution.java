package com.javarush.task.task01.task0129;

/* 
Считаем длину окружности

Реализуй метод printCircleLength. Параметр метода — радиус окружности. Метод должен вывести на экран длину окружности, рассчитанной по формуле: L = 2 * Pi * radius.
Результат — дробное число (тип double).
В качестве значения Pi используй значение 3.14.
*/

public class Solution {
    public static void main(String[] args) {
        printCircleLength(5);
    }

    public static void printCircleLength(int radius) {
        double l = 2 * 3.14 * radius;
        System.out.println(l);
    }
}