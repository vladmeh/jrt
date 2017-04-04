package com.javarush.task.task07.task0708;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самая длинная строка

1. Создай список строк.
2. Считай с клавиатуры 5 строк и добавь в список.
3. Используя цикл, найди самую длинную строку в списке.
4. Выведи найденную строку на экран.
5. Если таких строк несколько, выведи каждую с новой строки.


Требования:
1. Объяви переменную типа ArrayList (список строк) и сразу проинициализируй ee.
2. Программа должна считывать 5 строк с клавиатуры и записывать их в список.
3. Программа должна выводить самую длинную строку на экран.
4. Если есть несколько строк с длиной равной максимальной, то нужно вывести каждую из них с новой строки.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 5; i++)
        {
            list.add(reader.readLine());
        }

        int max_size = 0;
        int max_index = 0;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() > max_size){
                max_index = i;
                max_size = list.get(i).length();
            }
        }

        System.out.println(list.get(max_index));

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() == max_size && i != max_index)
                System.out.println(list.get(i));
        }
    }
}
