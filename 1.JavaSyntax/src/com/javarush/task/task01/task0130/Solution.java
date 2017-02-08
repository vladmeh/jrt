package com.javarush.task.task01.task0130;

/* 
Наш первый конвертер!
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(convertCelsiumToFahrenheit(40));
    }

    public static double convertCelsiumToFahrenheit(int celsium) {
<<<<<<< HEAD
        return celsium * 9.0/5.0 + 32;
=======
        double tf = (celsium * 9.0/5.0)+32.0;

        return tf;
>>>>>>> 6d0a2e93acded99e924263fe8dc5ddb5e35fb270
    }
}