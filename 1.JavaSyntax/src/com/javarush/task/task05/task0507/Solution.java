package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double x = 0;

        for (int i = 0; true; i++){
            int n = Integer.parseInt(reader.readLine());
            if (n == -1){
                System.out.println(x/i);
                break;
            }
            x += n;
        }
    }
}

