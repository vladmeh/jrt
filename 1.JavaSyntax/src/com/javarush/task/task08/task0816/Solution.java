package com.javarush.task.task08.task0816;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Добрая Зинаида и летние каникулы

Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» — «дата рождения».
Удалить из словаря всех людей, родившихся летом.


Требования:
1. Программа не должна выводить текст на экран.
2. Программа не должна считывать значения с клавиатуры.
3. Класс Solution должен содержать только три метода.
4. Метод createMap() должен создавать и возвращать словарь HashMap с типом элементов String, Date состоящий из 10 записей.
5. Метод removeAllSummerPeople() должен удалять из словаря всех людей, родившихся летом.
*/

public class Solution {
    public static HashMap<String, Date> createMap() {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", new Date("JUNE 1 1980"));
        map.put("Ivanov", new Date("JANUARY 10 1982"));
        map.put("Petrov", new Date("FEBRUARY 21 1990"));
        map.put("Sidorov", new Date("MARCH 8 1976"));
        map.put("Mikhaylov", new Date("APRIL 11 1972"));
        map.put("Bobrov", new Date("MAY 5 1986"));
        map.put("Sinincin", new Date("JULY 25 1992"));
        map.put("Zverev", new Date("AUGUST 1 1990"));
        map.put("Fedorov", new Date("SEPTEMBER 10 1985"));
        map.put("Kuznetcov", new Date("OCTOBER 19 1990"));

        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) {
        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()){
            Map.Entry<String, Date> pair = iterator.next();
            if (pair.getValue().getMonth() > 4 && pair.getValue().getMonth() < 8)
                iterator.remove();
        }
    }

    public static void main(String[] args) {

    }
}
