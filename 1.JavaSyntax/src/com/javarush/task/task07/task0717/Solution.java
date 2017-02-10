package com.javarush.task.task07.task0717;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Удваиваем слова
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        // Считать строки с консоли и объявить ArrayList list тут
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        int i = 0;
        while (i < 10)
        {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
            i++;
        }

        ArrayList<String> result = doubleValues(list);

        for (String s: result)
            System.out.println(s);
    }

    public static ArrayList<String> doubleValues(ArrayList<String> list) {
        ArrayList<String> result = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            result.add(list.get(i));
            result.add(list.get(i));
        }
        return result;
    }
}
