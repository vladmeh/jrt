package com.javarush.task.task02.task0217;

/* 
Минимум четырех чисел

Написать функцию, которая вычисляет минимум из четырёх чисел.
Функция min(a,b,c,d) должна использовать (вызывать) функцию min(a,b)

Подсказка:
Нужно написать тело двух существующих функций min.
*/
public class Solution {
    public static int min(int a, int b, int c, int d) {
        int m;

        if(min(a,b) < min(c,d))
            m = min(a,b);
        else
            m = min(c,d);

        return m;
    }

    public static int min(int a, int b) {
        int m2;
        if (a < b)
            m2 = a;
        else
            m2 = b;

        return m2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(min(-20, -10));
        System.out.println(min(-20, -10, -30, -40));
        System.out.println(min(-20, -10, -30, 40));
    }
}