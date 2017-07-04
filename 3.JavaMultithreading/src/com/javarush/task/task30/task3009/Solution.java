package com.javarush.task.task30.task3009;

import java.util.HashSet;
import java.util.Set;

/* 
Палиндром?
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getRadix("112"));        //expected output: [3, 27, 13, 15]
        System.out.println(getRadix("123"));        //expected output: [6]
        System.out.println(getRadix("5321"));       //expected output: []
        System.out.println(getRadix("1A"));         //expected output: []
    }

    private static Set<Integer> getRadix(String number) {

        Set<Integer> set = new HashSet<>();
        try {
            //проверяем является ли строка числом
            int n = Integer.parseInt(number);
            for (int i = 2; i <= 36; i++) {
                //проходим по системам счисления, переводим в строку
                String str = Integer.toString(n, i);
                if (palindrom(str)) set.add(i);

            }
        } catch (NumberFormatException ignore) {
        }

        return set;
    }

    private static boolean palindrom(String str) {
        return str.equals(new StringBuilder().append(str).reverse().toString());
    }
}