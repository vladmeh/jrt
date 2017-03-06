package com.javarush.task.task12.task1209;

/* 
Три метода возвращают минимальное из двух переданных в него чисел
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static int min(int a, int b) {
        int m2;
        if (a < b)
            m2 = a;
        else
            m2 = b;

        return m2;
    }

    public static long min(long a, long b) {
        long m2;
        if (a < b)
            m2 = a;
        else
            m2 = b;

        return m2;
    }

    public static double min(double a, double b) {
        double m2;
        if (a < b)
            m2 = a;
        else
            m2 = b;

        return m2;
    }
}
