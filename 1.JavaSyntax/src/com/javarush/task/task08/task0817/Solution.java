package com.javarush.task.task08.task0817;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* 
Нам повторы не нужны
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        HashMap<String, String> map = new HashMap<>();
        map.put("A", "J");
        map.put("B", "I");
        map.put("C", "A");
        map.put("D", "G");
        map.put("E", "F");
        map.put("F", "A");
        map.put("G", "D");
        map.put("H", "C");
        map.put("I", "B");
        map.put("J", "A");

        return map;
    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map) {
        HashSet<String> nameSet = new HashSet<>(map.values());

        for (String name: nameSet){
            if (Collections.frequency(map.values(), name) > 1)
                removeItemFromMapByValue(map, name);
        }


    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value) {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {

    }
}
