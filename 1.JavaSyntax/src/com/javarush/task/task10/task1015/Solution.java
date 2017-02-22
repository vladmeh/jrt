package com.javarush.task.task10.task1015;

import java.util.ArrayList;

/* 
Массив списков строк
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String>[] arrayOfStringList = createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList() {

        ArrayList<String>[] arrayLists = new ArrayList[3];

        for (int i = 0; i < arrayLists.length; i++) {
            ArrayList<String> list = new ArrayList<>();
            list.add("abc");
            list.add("abc");
            list.add("abc");
            arrayLists[i] = list;
        }

        return arrayLists;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList) {
        for (ArrayList<String> list : arrayOfStringList) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}