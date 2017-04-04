package com.javarush.task.task04.task0419;

/* 
Максимум четырех чисел

Ввести с клавиатуры четыре числа, и вывести максимальное из них.
Если числа равны между собой, необходимо вывести любое.


Требования:
1. Программа должна считывать числа c клавиатуры.
2. Программа должна выводить число на экран.
3. Программа должна выводить на экран максимальное из четырёх чисел.
4. Если числа равны между собой, необходимо вывести любое.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());
        int d = Integer.parseInt(reader.readLine());

        if (a > b && a > c && a > d)
            System.out.println(a);

        else if (b > a && b > c && b > d)
            System.out.println(b);

        else if (c > a && c > b && c > d)
            System.out.println(c);

        else if (d > a && d > b && d > c)
            System.out.println(d);

        else
            System.out.println(a);
    }
}
