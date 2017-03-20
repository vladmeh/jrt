package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream file = null;
        ArrayList<Integer> list = new ArrayList<>();
        try {
            //e:/JavaRush/test3.txt
            file = new FileInputStream(reader.readLine());
            Scanner in = new Scanner(file, "UTF-8");

            while (in.hasNext()){
                Integer n = Integer.parseInt(in.nextLine());
                if (n % 2 == 0)
                    list.add(n);
            }

            Collections.sort(list);

            for (Integer n: list)
                System.out.println(n);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                file.close();
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
