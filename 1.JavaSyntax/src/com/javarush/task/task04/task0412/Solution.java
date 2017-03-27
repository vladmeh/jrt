package com.javarush.task.task04.task0412;

/* 
Положительное и отрицательное число

Ввести с клавиатуры число.
Если число положительное, то увеличить его в два раза.
Если число отрицательное, то прибавить единицу.
Если введенное число равно нулю, необходимо вывести ноль.
Вывести результат на экран.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        if (n > 0)
            System.out.println(n * 2);
        else if (n < 0)
            System.out.println(n + 1);
        else
            System.out.println(0);

    }

}