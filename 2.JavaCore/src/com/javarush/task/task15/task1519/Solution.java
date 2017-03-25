package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/* 
Разные методы для разных типов

1. Считать с консоли данные, пока не введено слово «exit«.
2. Для каждого значения, кроме «exit«, вызвать метод print. Если значение:
2.1. содержит точку ‘.‘, то вызвать метод print для Double;
2.2. больше нуля, но меньше 128, то вызвать метод print для short;
2.3. больше нуля или больше либо равно 128, то вызвать метод print для Integer;
2.4. иначе, вызвать метод print для String.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            //Программа должна считывать данные с клавиатуры.
            String s = reader.readLine();
            //Программа должна прекращать считывать данные с клавиатуры после того как была введена строка "exit".
            if ("exit".equals(s)) break;

            try{
                //Если введенная строка содержит точку(".")
                // и может быть корректно преобразована в число типа Double
                // - должен быть вызван метод print(Double value).
                if (s.contains("."))
                    print(Double.parseDouble(s));
                //Если введенная строка может быть корректно преобразована в число типа short
                // и полученное число больше 0, но меньше 128 - должен быть вызван метод print(short value).
                else if (Short.parseShort(s) > 0 && Short.parseShort(s) < 128)
                    print(Short.parseShort(s));
                //Если введенная строка может быть корректно преобразована в число типа Integer
                // и полученное число меньше или равно 0 или больше или равно 128
                // - должен быть вызван метод print(Integer value).
                else if (Integer.parseInt(s) <= 0 || Integer.parseInt(s) >= 128)
                    print(Integer.parseInt(s));
                //Во всех остальных случаях должен быть вызван метод print(String value).
                else
                    print(s);
            }
            catch (NumberFormatException e){
                print(s);
            }
        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
