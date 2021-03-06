package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Самые частые байты

Ввести с консоли имя файла.
Найти байт или байты с максимальным количеством повторов.
Вывести их на экран через пробел.
Закрыть поток ввода-вывода.


Требования:
1. Программа должна считывать имя файла с консоли.
2. Для чтения из файла используй поток FileInputStream.
3. В консоль через пробел должны выводиться все байты из файла с максимальным количеством повторов.
4. Данные в консоль должны выводится в одну строку.
5. Поток чтения из файла должен быть закрыт.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //E:\JavaRush\test2.txt
        FileInputStream inputStream = new FileInputStream(
                new BufferedReader(
                        new InputStreamReader(System.in)
                ).readLine());

        Map<Integer, Integer> map = new HashMap<>();

        while (inputStream.available() > 0){
            int data = inputStream.read();

            if (map.containsKey(data))
                map.put(data, map.get(data)+1);
            else
                map.put(data, 1);
        }

        inputStream.close();

        int n = 0;
        for (Map.Entry<Integer, Integer> entry: map.entrySet())
            if (entry.getValue() > n) n = entry.getValue();

        for (Map.Entry<Integer, Integer> entry: map.entrySet())
            if (entry.getValue().equals(n))
                System.out.printf("%d ", entry.getKey());

    }
}
