package com.javarush.task.task07.task0703;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Общение одиноких массивов
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] list = new String[10];
        int[] number = new int[10];

        for (int i = 0; i < list.length; i++) {
            list[i] = reader.readLine();
            number[i] = list[i].length();
        }

        for (int i = 0; i < number.length; i++) {
            System.out.println(number[i]);
        }
    }
}
