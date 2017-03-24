package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики 1

В статическом блоке инициализировать labels 5 различными парами ключ-значение.
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    //Статический блок инициализации
    static
    {
        labels.put(2d, "B");
        labels.put(3d, "C");
        labels.put(4d, "D");
        labels.put(5d, "E");
        labels.put(1d, "A");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
