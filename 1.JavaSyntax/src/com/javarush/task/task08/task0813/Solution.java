package com.javarush.task.task08.task0813;

import java.util.HashSet;

/* 
20 слов на букву «Л»

Создать множество строк (Set<String>), занести в него 20 слов на букву «Л».


Требования:
1. Программа не должна выводить текст на экран.
2. Программа не должна считывать значения с клавиатуры.
3. Класс Solution должен содержать только два метода.
4. Метод createSet() должен создавать и возвращать множество HashSet.
5. Множество из метода createSet() должно содержать 20 слов на букву «Л».
*/

public class Solution {
    public static HashSet<String> createSet() {
        HashSet<String> listSet = new HashSet<>();
        listSet.add("Лето");
        listSet.add("Лампа");
        listSet.add("Лютик");
        listSet.add("Лена");
        listSet.add("Лист");
        listSet.add("Люцифер");
        listSet.add("Ласточка");
        listSet.add("Лидер");
        listSet.add("Лакомка");
        listSet.add("Лейка");
        listSet.add("Лото");
        listSet.add("Лань");
        listSet.add("Лень");
        listSet.add("Люстра");
        listSet.add("Ламборджини");
        listSet.add("Ленинград");
        listSet.add("Ленин");
        listSet.add("Лактоза");
        listSet.add("Лавка");
        listSet.add("Лавина");

        return listSet;
    }

    public static void main(String[] args) {

    }
}
