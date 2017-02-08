package com.javarush.task.task04.task0427;

/* 
Описываем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String s = reader.readLine();
        int x = Integer.parseInt(s);

        if (x < 1 || x > 999)
            return;

        if (s.length() == 1){
            if (x % 2 == 0)
                System.out.println("четное однозначное число");
            else
                System.out.println("нечетное однозначное число");
        }

        if (s.length() == 2){
            if (x % 2 == 0)
                System.out.println("четное двузначное число");
            else
                System.out.println("нечетное двузначное число");
        }

        if (s.length() == 3){
            if (x % 2 == 0)
                System.out.println("четное трехзначное число");
            else
                System.out.println("нечетное трехзначное число");
        }

    }
}
