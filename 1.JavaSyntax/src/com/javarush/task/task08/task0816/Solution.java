package com.javarush.task.task08.task0816;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* 
Добрая Зинаида и летние каникулы
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
        //напишите тут ваш код

    }

    public static void main(String[] args) {
        HashMap<String, Date> map = createMap();

        for (Map.Entry<String, Date> pair: map.entrySet())
            System.out.println(pair.getKey() + " " + pair.getValue());
    }
}
