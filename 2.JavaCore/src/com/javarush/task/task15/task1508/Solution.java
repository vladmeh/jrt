package com.javarush.task.task15.task1508;

/* 
ООП - Перегрузка - убираем лишнее
1. Подумайте, какая из реализаций метода print будет вызвана.
2. Удалите все лишние реализации метода print.

Основная цепочка byte->short->int->long-->dooble
 int -> dooble
 int --> float -> dooble
 long --> float
 char -> int
 --> потеря точности
*/

public class Solution {
    public static void main(String[] args) {
        print(1); //Целое число - по умолчанию int - будет расширена до long
    }

    /*public static void print(byte b) {
        System.out.println("Я буду Java прогером!");
    }

    public static void print(double d) {
        System.out.println("Я буду Java прогером!");
    }*/

    public static void print(long l) {
        System.out.println("Я буду Java прогером!");
    }

    /*public static void print(float f) {
        System.out.println("Я буду Java прогером!");
    }

    public static void print(char c) {
        System.out.println("Я буду Java прогером!");
    }*/
}
