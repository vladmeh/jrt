package com.javarush.task.task07.task0709;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Выражаемся покороче

1. Создай список строк.
2. Считай с клавиатуры 5 строк и добавь в список.
3. Используя цикл, найди самую короткую строку в списке.
4. Выведи найденную строку на экран.
5. Если таких строк несколько, выведи каждую с новой строки.


Требования:
1. Объяви переменную типа список строк и сразу проинициализируй ee.
2. Программа должна считывать 5 строк с клавиатуры и записывать их в список.
3. Программа должна выводить самую короткую строку на экран.
4. Если есть несколько строк с длиной равной минимальной, то нужно вывести каждую из них с новой строки.
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
