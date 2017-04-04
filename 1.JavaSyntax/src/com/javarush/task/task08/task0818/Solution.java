package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Map;

/* 
Только для богачей

Создать словарь (Map<String, Integer>) и занести в него десять записей по принципу: «фамилия» — «зарплата».
Удалить из словаря всех людей, у которых зарплата ниже 500.


Требования:
1. Программа не должна выводить текст на экран.
2. Программа не должна считывать значения с клавиатуры.
3. Класс Solution должен содержать только три метода.
4. Метод createMap() должен создавать и возвращать словарь HashMap с типом элементов String, Integer состоящих из 10 записей по принципу «фамилия» - «зарплата».
5. Метод removeItemFromMap() должен удалять из словаря всех людей, у которых зарплата ниже 500.
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("A", 100);
        map.put("B", 200);
        map.put("C", 300);
        map.put("D", 400);
        map.put("E", 500);
        map.put("F", 600);
        map.put("G", 700);
        map.put("H", 800);
        map.put("I", 900);
        map.put("J", 100);

        return map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        //Создаем копию карты
        HashMap<String, Integer> copyMap = new HashMap<>(map);

        //проходимся по копии
        for (Map.Entry<String, Integer> pair: copyMap.entrySet()){
            //Если в копии значение меньше 500
            if (pair.getValue() < 500)
                map.remove(pair.getKey()); //Из основной карты удаляем елемент с ключем из копии
        }
    }

    public static void main(String[] args) {
        //Проверка по условию не надо, перед отправкой удалить
        HashMap<String, Integer> map = createMap();
        removeItemFromMap(map);
        for (Map.Entry<String, Integer> pair: map.entrySet())
            System.out.println(pair.getKey() + ": " + pair.getValue());
    }
}