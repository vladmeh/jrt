package com.javarush.task.task10.task1019;

import java.io.*;
import java.util.HashMap;

/* 
Функциональности маловато!
*/

public class Solution {
    static Integer index;
    static String name;

    public static void main(String[] args) throws IOException {
        HashMap<String, Integer> map = new HashMap<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            String s = reader.readLine();
            if (s.isEmpty()) break;
            Solution.index = Integer.parseInt(s);
            Solution.name = reader.readLine();
            map.put(name, index);
        }


        for (HashMap.Entry<String, Integer> pair : map.entrySet()) {
            name = pair.getKey();
            index = pair.getValue();
            System.out.println(index + " " + name);
        }
    }
}
