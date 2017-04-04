package com.javarush.task.task04.task0417;

/* 
Существует ли пара?

Ввести с клавиатуры три целых числа. Определить, имеется ли среди них хотя бы одна пара равных между собой чисел.
Если такая пара существует, вывести на экран числа через пробел.
Если все три числа равны между собой, то вывести все три.

Пример для чисел 1 2 2:
2 2

Пример для чисел 2 2 2:
2 2 2


Требования:
1. Программа должна считывать числа c клавиатуры.
2. Программа должна содержать System.out.println() или System.out.print()
3. Если два числа равны между собой, необходимо вывести числа на экран.
4. Если все три числа равны между собой, необходимо вывести все три.
5. Если нет равных чисел, ничего не выводить.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());

        if (a == b && a != c)
            System.out.println(a + " " + b);

        if (a == c && a != b)
            System.out.println(a + " " + c);

        if (b == c && b != a)
            System.out.println(b + " " + c);

        if (a == b && b == c)
            System.out.println(a + " " + b + " " + c);
    }
}