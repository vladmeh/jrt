package com.javarush.task.task15.task1506;

/* 
Что-то лишнее
1. Программа должна выводить следующее:
Это double
Это Object
Это double
Это Integer
Это double

2. Удали реализации всех лишних методов
*/

public class Solution {
    public static void main(String[] args) {
        print((short) 1); //short расширяем до dooble
        print((Number) 1); //Number это Object
        print(1); //Целое число - int - расширяем до dooble
        print((Integer) 1); //Integer
        print((int) 1); //int - расширяем до dooble
    }

    public static void print(double i) {
        System.out.println("Это double");
    }

    public static void print(Integer i) {
        System.out.println("Это Integer");
    }

    /*public static void print(int i) {
        System.out.println("Это Integer");
    }*/

    /*public static void print(Short i) {
        System.out.println("Это Object");
    }*/

    public static void print(Object i) {
        System.out.println("Это Object");
    }

    /*public static void print(Double i) {
        System.out.println("Это double");
    }*/

    /*public static void print(float i) {
        System.out.println("Это Double");
    }*/
}
