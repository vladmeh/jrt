package com.javarush.task.task08.task0815;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* 
Перепись населения

Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» — «Имя».
Проверить сколько людей имеют совпадающие с заданным именем или фамилией.


Требования:
1. Программа не должна выводить текст на экран.
2. Программа не должна считывать значения с клавиатуры.
3. Класс Solution должен содержать только четыре метода.
4. Метод createMap() должен создавать и возвращать словарь HashMap с типом элементов String, String состоящих из 10 записей по принципу «Фамилия» - «Имя».
5. Метод getCountTheSameFirstName() должен возвращать число людей у которых совпадает имя.
6. Метод getCountTheSameLastName() должен возвращать число людей у которых совпадает фамилия.
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
