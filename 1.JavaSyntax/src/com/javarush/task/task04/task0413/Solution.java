package com.javarush.task.task04.task0413;

/* 
День недели
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String weekday;

        switch (n) {
            case 1: weekday = "понедельник";
                break;
            case 2: weekday = "вторник";
                break;
            case 3: weekday = "среда";
                break;
            case 4: weekday = "четверг";
                break;
            case 5: weekday = "пятница";
                break;
            case 6: weekday = "суббота";
                break;
            case 7: weekday = "воскресенье";
                break;
            default: weekday = "такого дня недели не существует";
                break;
        }

        System.out.println(weekday);
    }
}