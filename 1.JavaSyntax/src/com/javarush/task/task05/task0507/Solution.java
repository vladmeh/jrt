package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
<<<<<<< HEAD
        double sum = 0.0;

        for (int i = 0; true; i++){
            int x = Integer.parseInt(reader.readLine());
            if( x == -1){
                System.out.println(sum / i);
                break;
            }
            sum += x;
=======
        double x = 0;

        for (int i = 0; true; i++){
            int n = Integer.parseInt(reader.readLine());
            if (n == -1){
                System.out.println(x/i);
                break;
            }
            x += n;
>>>>>>> 6d0a2e93acded99e924263fe8dc5ddb5e35fb270
        }
    }
}

