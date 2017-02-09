package com.javarush.task.task07.task0709;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Выражаемся покороче
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 5; i++)
        {
            list.add(reader.readLine());
        }

        //Считаем что самая короткая строка первая с индексом 0
        int min_index = 0;
        int min_size = list.get(min_index).length();

        //Сравниваем весь массив с первой строкой
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() < min_size){
                min_size = list.get(i).length();
                min_index = i;
            }
        }

        //Выводим самую короткую строчку
        System.out.println(list.get(min_index));

        //Ищем строки такойже длины и выводим их
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() == min_size && i != min_index)
                System.out.println(list.get(i));
        }
    }
}
