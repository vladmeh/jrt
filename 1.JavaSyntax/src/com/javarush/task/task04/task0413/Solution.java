package com.javarush.task.task04.task0413;

/* 
День недели

Ввести с клавиатуры номер дня недели, в зависимости от номера вывести название
«понедельник», «вторник», «среда», «четверг», «пятница», «суббота», «воскресенье»,
если введен номер больше 7 или меньше 1 – вывести «такого дня недели не существует».

Пример для номера 5:
пятница

Пример для номера 10:
такого дня недели не существует


Требования:
1. Программа должна считывать число c клавиатуры.
2. Программа должна выводить текст на экран.
3. Если введено число от 1 до 7, необходимо вывести день недели.
4. Если введено число не входящее в интервал от 1 до 7, то вывести уведомление что такого дня недели не существует.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String weekday;

        switch (n) {
            case 1: weekday = "понедельник";
                break;
            case 2: weekday = "вторник";
                break;
            case 3: weekday = "среда";
                break;
            case 4: weekday = "четверг";
                break;
            case 5: weekday = "пятница";
                break;
            case 6: weekday = "суббота";
                break;
            case 7: weekday = "воскресенье";
                break;
            default: weekday = "такого дня недели не существует";
                break;
        }

        System.out.println(weekday);
    }
}