package com.javarush.task.task08.task0802;

/* 
HashMap из 10 пар
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
