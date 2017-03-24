package com.javarush.task.task15.task1515;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Статики 2

1. В статическом блоке считайте две переменные с консоли А и В с типом int.
2. Не забыть про IOException, который надо обработать в блоке catch.
3. Закрыть поток ввода методом close().
*/

public class Solution {
    public static int A;
    public static int B;

    public static final int MIN = min(A, B);

    public static void main(String[] args) {
        System.out.println(MIN);
    }

    public static int min(int a, int b) {
        return a < b ? a : b;
    }

    //Статический блок инициализации
    static
    {
        //Открываем поток ввода
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            //считываем переменные с консоли
            A = Integer.parseInt(reader.readLine());
            B = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            //обрабатываем исключение
            e.printStackTrace();
        } finally {
            try {
                //Закрываем поток ввода
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
