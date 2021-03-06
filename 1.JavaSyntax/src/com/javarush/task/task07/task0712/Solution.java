package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые

1. Создай список строк.
2. Добавь в него 10 строчек с клавиатуры.
3. Узнай, какая строка в списке встретится раньше: самая короткая или самая длинная.
Если таких строк несколько, то должны быть учтены самые первые из них.
4. Выведи на экран строку из п.3.


Требования:
1. Объяви переменную типа список строк и сразу проинициализируй ee.
2. Программа должна считывать 10 строк с клавиатуры и добавлять их в список.
3. Программа должна выводить на экран самую короткую строку, если она была раньше самой длинной.
4. Программа должна выводить на экран самую длинную строку, если она была раньше самой короткой.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //Создай список строк.
        ArrayList<String> list = new ArrayList<>();

        //Добавь в него 10 строчек с клавиатуры.
        for (int i = 0; i < 10; i++)
            list.add(reader.readLine());

        //Считаем что самая короткая строка первая с индексом 0
        int min_index = 0;
        int min_size = list.get(min_index).length();

        //Считаем что самая длинная строка первая с индексом 0
        int max_index = 0;
        int max_size = list.get(max_index).length();

        //Сравниваем весь массив с первой строкой
        for (int i = 0; i < list.size(); i++) {
            //находим самую короткую строку
            if (list.get(i).length() < min_size){
                min_size = list.get(i).length();
                min_index = i;
            }

            //находим самую длинную строку
            if (list.get(i).length() > max_size){
                max_size = list.get(i).length();
                max_index = i;
            }
        }

        //по индексу строки определяем какая встречается раньше
        //Выведи на экран строку,
        //если таких строк несколько ввыводиться первая
        if (min_index < max_index)
            System.out.println(list.get(min_index));
        else
            System.out.println(list.get(max_index));

    }
}
