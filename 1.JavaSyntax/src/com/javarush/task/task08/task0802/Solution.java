package com.javarush.task.task08.task0802;

/* 
HashMap из 10 пар

Создать коллекцию HashMap<String, String>, занести туда 10 пар строк:
арбуз — ягода,
банан — трава,
вишня — ягода,
груша — фрукт,
дыня — овощ,
ежевика — куст,
жень-шень — корень,
земляника — ягода,
ирис — цветок,
картофель — клубень.
Вывести содержимое коллекции на экран, каждый элемент с новой строки.

Пример вывода (тут показана только одна строка):
картофель - клубень


Требования:
1. Объяви переменную коллекции HashMap с типом элементов String, String и сразу проинициализируй ee.
2. Программа не должна считывать значения с клавиатуры.
3. Программа должна добавлять в коллекцию 10 пар строк, согласно условию.
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws Exception {
        HashMap<String, String> plantsHashMap = new HashMap<>();
        plantsHashMap.put("арбуз", "ягода");
        plantsHashMap.put("банан", "трава");
        plantsHashMap.put("вишня", "ягода");
        plantsHashMap.put("груша", "фрукт");
        plantsHashMap.put("дыня", "овощ");
        plantsHashMap.put("ежевика", "куст");
        plantsHashMap.put("жень-шень", "корень");
        plantsHashMap.put("земляника", "ягода");
        plantsHashMap.put("ирис", "цветок");
        plantsHashMap.put("картофель", "клубень");

        for (Map.Entry<String, String> pair: plantsHashMap.entrySet()){
            String key = pair.getKey();
            String value = pair.getValue();
            System.out.println(key + " - " + value);
        }

    }
}
