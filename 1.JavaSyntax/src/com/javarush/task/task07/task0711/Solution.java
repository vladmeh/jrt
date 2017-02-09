package com.javarush.task.task07.task0711;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Удалить и вставить
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //Создай список строк.
        ArrayList<String> list = new ArrayList<>();

        //Добавь в него 5 строк с клавиатуры.
        for (int i = 0; i < 5; i++) {
            list.add(reader.readLine());
        }

        //Повторить 13 раз.
        for (int i = 0; i < 13; i++) {
            //Удали последнюю строку
            String item = list.remove(list.size()-1);
            //и вставь её в начало
            list.add(0,item);
        }

        //Используя цикл выведи содержимое на экран, каждое значение с новой строки.
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
