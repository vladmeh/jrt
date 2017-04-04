package com.javarush.task.task04.task0422;

/* 
18+

Ввести с клавиатуры имя и возраст. Если возраст меньше 18 вывести надпись «Подрасти еще».


Требования:
1. Программа должна считывать строки c клавиатуры.
2. Программа должна использовать команду System.out.println() или System.out.print().
3. Если возраст меньше 18 вывести сообщение "Подрасти еще".
4. Если возраст больше либо равно 18 ничего не выводить.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String name = reader.readLine();
        int age = Integer.parseInt(reader.readLine());

        if (age < 18)
            System.out.println("Подрасти еще");
    }
}
