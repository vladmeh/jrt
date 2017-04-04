package com.javarush.task.task07.task0704;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Переверни массив

1. Создать массив на 10 чисел.
2. Ввести с клавиатуры 10 чисел и записать их в массив.
3. Расположить элементы массива в обратном порядке.
4. Вывести результат на экран, каждое значение выводить с новой строки.


Требования:
1. Программа должна создавать массив на 10 целых чисел.
2. Программа должна считывать числа для массива с клавиатуры.
3. Программа должна выводить 10 строчек, каждую с новой строки.
4. Массив должен быть выведен на экран в обратном порядке.
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

