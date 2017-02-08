package com.javarush.task.task04.task0420;

/* 
Сортировка трех чисел
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());

        Integer[] data = {a, b, c};

        Arrays.sort(data, Collections.reverseOrder());

        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i] + " ");
        }
    }
}
