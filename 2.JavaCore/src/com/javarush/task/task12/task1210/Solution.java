package com.javarush.task.task12.task1210;

/* 
Три метода возвращают максимальное из двух переданных в него чисел
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static int max(int a, int b){
        if (a > b)
            return a;

        return b;
    }

    public static long max(long a, long b){
        if (a > b)
            return a;

        return b;
    }

    public static double max(double a, double b){
        if (a > b)
            return a;

        return b;
    }
}
