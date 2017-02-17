package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList() {
        HashMap<String, String> peoples = new HashMap<>();

        peoples.put("A", "G");
        peoples.put("B", "G");
        peoples.put("C", "H");
        peoples.put("C", "G");
        peoples.put("E", "F");
        peoples.put("F", "E");
        peoples.put("G", "D");
        peoples.put("H", "C");
        peoples.put("I", "B");
        peoples.put("J", "A");

        return peoples;
    }

    public static void printPeopleList(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
