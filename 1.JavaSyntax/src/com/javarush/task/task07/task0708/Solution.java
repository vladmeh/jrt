package com.javarush.task.task07.task0708;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самая длинная строка
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
