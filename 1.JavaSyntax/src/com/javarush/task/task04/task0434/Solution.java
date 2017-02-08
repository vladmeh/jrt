package com.javarush.task.task04.task0434;


/* 
Таблица умножения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        int i = 1;
        while (i <= 10){
            int k = 1;
            while (k <= 10){
                System.out.print(k*i + " ");
                k++;
            }
            System.out.println();
            i++;
        }

    }
}
