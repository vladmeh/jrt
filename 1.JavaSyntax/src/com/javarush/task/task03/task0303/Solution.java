package com.javarush.task.task03.task0303;

/* 
Обмен валют
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(convertEurToUsd(60, 1.8));
        System.out.println(convertEurToUsd(100, 1.8));
    }

    public static double convertEurToUsd(int eur, double course) {
        double dollar = eur * course;

        return dollar;
    }
}
