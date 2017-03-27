package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

/* 
Парсер реквестов

Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) — для чисел (дробные числа разделяются точкой)
alert(String value) — для строк
Обрати внимание на то, что метод alert необходимо вызывать ПОСЛЕ вывода списка всех параметров на экран.

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        URL href = new URL(reader.readLine());
        ArrayList<String> obj = new ArrayList<>();

        String[] params = href.getQuery().split("&");
        for (String s: params){
            System.out.printf("%s ", s.split("=")[0]);

            if (s.split("=")[0].equals("obj") && s.split("=").length > 1)
                obj.add(s.split("=")[1]);
        }

        System.out.println();

        if (obj.size() != 0){
            for (String s: obj){
                try {
                    alert(Double.parseDouble(s));
                }
                catch (NumberFormatException e){
                    alert(s);
                }
            }
        }



    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
