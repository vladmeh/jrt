package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Один большой массив и два маленьких
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] data = new int[20];
        int[] arr1 = new int[10];
        int[] arr2 = new int[10];

        for (int i = 0; i < data.length; i++)
            data[i] = Integer.parseInt(reader.readLine());

        for (int i = 0; i < arr1.length; i++)
            arr1[i] = data[i];

        for (int i = 0; i < arr2.length; i++)
            arr2[i] = data[i+10];

        for (int i = 0; i < arr2.length; i++)
            System.out.println(arr2[i]);
    }
}
