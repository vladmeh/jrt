package com.javarush.task.task08.task0815;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* 
Перепись населения
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        HashMap<String, String> map = new HashMap<>();
        map.put("A", "J");
        map.put("B", "I");
        map.put("C", "H");
        map.put("D", "G");
        map.put("E", "F");
        map.put("F", "E");
        map.put("G", "D");
        map.put("H", "C");
        map.put("I", "B");
        map.put("J", "A");

        return map;

    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name) {
        int count = 0;

        for (Map.Entry<String, String> pair: map.entrySet())
            if (name.equals(pair.getValue())) count++;

        return count;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName) {
        int count = 0;

        for (Map.Entry<String, String> pair: map.entrySet())
            if (lastName.equals(pair.getKey())) count++;

        return count;

    }

    public static void main(String[] args) {

    }
}
