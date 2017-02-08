package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] data = new int[15];

        for (int i = 0; i < data.length; i++)
            data[i] = Integer.parseInt(reader.readLine());

        int a = 0, b = 0;
        for (int i = 0; i < data.length; i++) {
            if (i % 2 == 0)
                a += data[i];
            else
                b += data[i];
        }

        if (a > b) System.out.println("В домах с четными номерами проживает больше жителей.");
        if (b > a) System.out.println("В домах с нечетными номерами проживает больше жителей.");
    }
}
