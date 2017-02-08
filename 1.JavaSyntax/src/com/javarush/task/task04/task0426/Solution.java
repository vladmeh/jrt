package com.javarush.task.task04.task0426;

/* 
Ярлыки и числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(reader.readLine());

        if (x < 0 && x % 2 == 0) System.out.println("отрицательное четное число");
        if (x < 0 && x % 2 != 0) System.out.println("отрицательное нечетное число");
        if (x == 0) System.out.println("ноль");
        if (x > 0 && x % 2 == 0) System.out.println("положительное четное число");
        if (x > 0 && x % 2 != 0) System.out.println("положительное нечетное число");
    }
}
