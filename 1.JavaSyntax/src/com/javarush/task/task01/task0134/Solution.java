package com.javarush.task.task01.task0134;

/* 
Набираем воду в бассейн
Нужно посчитать, сколько литров воды нужно для заполнения бассейна до бортов.
Известно, что бассейн имеет линейные размеры a × b × c, заданные в метрах.
Эти размеры передаются в метод getVolume.
Метод должен вернуть количество литров воды, которое нужно для наполнения бассейна.

Пример:
Метод getVolume вызывается с параметрами 25, 5, 2.

Пример вывода:
250000
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getVolume(25, 5, 2));
    }

    public static long getVolume(int a, int b, int c) {
        int kubm = a * b * c;
        int kubl = 1000;
        return kubm * kubl;
    }
}