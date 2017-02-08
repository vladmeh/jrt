package com.javarush.task.task04.task0419;

/* 
Максимум четырех чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());
        int d = Integer.parseInt(reader.readLine());

        if (a > b && a > c && a > d)
            System.out.println(a);

        else if (b > a && b > c && b > d)
            System.out.println(b);

        else if (c > a && c > b && c > d)
            System.out.println(c);

        else if (d > a && d > b && d > c)
            System.out.println(d);

        else
            System.out.println(a);
    }
}
