package com.javarush.task.task03.task0309;

/* 
Сумма 10 чисел
*/

public class Solution {
    public static void main(String[] args) {
        int k = 1;
        for (int i = 1; i < 11; i++) {
            if(i > 1)
                k = k + i;

            System.out.println(k);
        }
    }
}
