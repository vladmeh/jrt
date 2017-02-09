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

        int l = 0;
        int k = 0;
        ArrayList<Integer> index = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {

            System.out.println(list.get(i).length());
            /*if (list.get(i).length() > l){
                l = list.get(i).length();
                k = i;
            }

            if (list.get(i).length() == l){
                index.add(k);
            }*/
        }

        /*if (index.size() > 0)
            System.out.println(index.size());
        else
            System.out.println(list.get(k));*/



    }
}
