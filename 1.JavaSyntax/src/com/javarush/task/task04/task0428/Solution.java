package com.javarush.task.task04.task0428;

/* 
Положительное число
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int x = 0;

        for (int i = 0; i < 3; i++) {
            int y = Integer.parseInt(reader.readLine());
            if (y > 0) x++;
        }

        System.out.println(x);
    }
}
