package com.javarush.task.task01.task0140;

import java.util.Scanner;

/* 
Выводим квадрат числа

Напиши программу, которая считывает с клавиатуры целое число a и выводит квадрат этого числа (a * a).
Для считывания данных с клавиатуры используй метод nextInt() класса Scanner.
*/

public class Solution {
    public static void main(String[] args) {
        int a;
        Scanner scanner = new Scanner(System.in);
        a = scanner.nextInt();

        System.out.println(a*a);
    }
}