package com.javarush.task.task04.task0414;

/* 
Количество дней в году
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int nYear = Integer.parseInt(reader.readLine());

        int x;

        if (nYear % 4 != 0 || nYear % 100 == 0 && nYear % 400 != 0)
            x = 365;
        else
            x = 366;

        System.out.println("количество дней в году: " + x);
    }
}