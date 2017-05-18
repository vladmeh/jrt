package com.javarush.task.task22.task2202;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mvl on 18.05.2017.
 */
public class MySolution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {
        if (string == null || string.isEmpty()) {
            throw new TooShortStringException();
        }

        List<Integer> list = new ArrayList<>();
        char[] arr = string.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' '){
                list.add(i);
            }
        }

        if (list.size() < 5)
            throw new TooShortStringException();
        else
            return string.substring(list.get(0)+1, list.get(4));
    }

    public static class TooShortStringException extends RuntimeException{
    }
}
