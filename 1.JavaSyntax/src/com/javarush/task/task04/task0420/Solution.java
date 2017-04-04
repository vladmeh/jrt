package com.javarush.task.task04.task0420;

/* 
Сортировка трех чисел

Ввести с клавиатуры три числа, и вывести их в порядке убывания.
Выведенные числа должны быть разделены пробелом.


Требования:
1. Программа должна считывать числа c клавиатуры.
2. Программа должна выводить числа на экран.
3. Выведенные числа должны быть разделены пробелом.
4. Программа должна выводить числа в порядке убывания.
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
