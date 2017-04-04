package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Один большой массив и два маленьких

1. Создать массив на 20 чисел.
2. Ввести в него значения с клавиатуры.
3. Создать два массива на 10 чисел каждый.
4. Скопировать большой массив в два маленьких: половину чисел в первый маленький, вторую половину во второй маленький.
5. Вывести второй маленький массив на экран, каждое значение выводить с новой строки.


Требования:
1. Программа должна создавать большой массив на 20 целых чисел.
2. Программа должна считывать числа для большого массива с клавиатуры.
3. Программа должна создавать два маленьких массив на 10 чисел каждый.
4. Программа должна скопировать одну половину большого массива в первый маленький, а второю - во второй и вывести его на экран.
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
