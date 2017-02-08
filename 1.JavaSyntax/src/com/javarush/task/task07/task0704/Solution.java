package com.javarush.task.task07.task0704;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Переверни массив
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //Создать массив на 10 чисел
        int[] list = new int[10];

        // Ввести с клавиатуры 10 чисел и записать их в массив
        for (int i = 0; i < list.length; i++)
            list[i] = Integer.parseInt(reader.readLine());

        //Вывести результат на экран, каждое значение выводить с новой строки.
        for (int i = list.length - 1; i >= 0; i--)
            System.out.println(list[i]);

    }
}

