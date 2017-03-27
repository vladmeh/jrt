package com.javarush.task.task02.task0216;

/* 
Минимум трёх чисел

Написать функцию, которая вычисляет минимум из трёх чисел.

Подсказка:
Нужно написать тело существующей функции min.
*/
public class Solution {
    public static int min(int a, int b, int c) {
        int m2;
        if (a < b && a < c)
            m2 = a;
        else if (b < a && b < c)
            m2 = b;
        else
            m2 = c;

        return m2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(min(1, 2, 3));
        System.out.println(min(-1, -2, -3));
        System.out.println(min(3, 5, 3));
        System.out.println(min(10, 5, 10));
    }

}