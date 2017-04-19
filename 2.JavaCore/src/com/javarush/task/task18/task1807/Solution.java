package com.javarush.task.task18.task1807;

/* 
Подсчет запятых

С консоли считать имя файла.
Посчитать в файле количество символов ‘,‘, количество вывести на консоль.
Закрыть потоки.

Подсказка:
нужно сравнивать с ascii-кодом символа ‘,‘.


Требования:
1. Программа должна считывать имя файла с консоли.
2. Для чтения из файла используй поток FileInputStream.
3. В консоль должно выводится число запятых в считанном файле.
4. Поток чтения из файла должен быть закрыт.
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //Создаем поток-чтения-байт-из-файла
        //С консоли читаем имя файла (D:\JavaRush\test1.txt)
        FileInputStream inputStream = new FileInputStream(
                new BufferedReader(
                        new InputStreamReader(System.in)
                ).readLine());

        int n = 0;
        while (inputStream.available() > 0){
            // Сужаем тип char до byte приведением типов
            // получаем байтовое значение запятой
            // char ch = ','; byte bt = (byte) ch;
            //
            // читаем поток побайтово и сравниваем со значением запятой
            if (inputStream.read() == (byte)',') n++;
        }
        //Закрываем поток
        inputStream.close();

        System.out.println(n);

    }
}
