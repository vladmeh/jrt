package com.javarush.task.task02.task0219;

/* 
Печатаем трижды

Реализуй метод print3. Метод должен вывести переданную строку (слово) на экран три раза, но в одной строке.
Слова должны быть разделены пробелом и не должны сливаться в одно.
*/
public class Solution {
    public static void print3(String s) {
        for (int i = 0; i < 3; i++) {
            System.out.print(s + " ");
        }

    }

    public static void main(String[] args) {
        print3("window");
        print3("file");
    }
}