package com.javarush.task.task03.task0317;

/* 
Путь самурая
Выведи на экран: 日本語
*/

public class Solution {
    public static void main(String[] args) {
        //System.out.print("日本語");
        char a = '\u65E5';
        char b = '\u672c';
        char c = '\u8a9e';

        System.out.printf("%s%s%s", a, b, c);
    }
}
