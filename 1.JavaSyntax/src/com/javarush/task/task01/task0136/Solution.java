package com.javarush.task.task01.task0136;

/* 
Да хоть на Луну!
реализуй метод getWeight(int), который принимает вес тела (в Ньютонах) на Земле, и возвращает,
сколько это тело будет весить на Луне (в Ньютонах).
Тип возвращаемого значения — double.

Пример:
Метод getWeight вызывается с параметром 888.

Пример вывода:
150.96
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getWeight(888));
    }

    public static double getWeight(int weightEarth) {
        double weightLuna = weightEarth * 0.17;

        return weightLuna;
    }
}