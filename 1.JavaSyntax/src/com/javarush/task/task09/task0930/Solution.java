package com.javarush.task.task09.task0930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[list.size()]);
        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {

        //Вычисляем количество строк и чисел в массиве
        int counterW = 0;
        int counterN = 0;
        for (String s: array){
            if (isNumber(s))
                counterN++;
            else
                counterW++;
        }

        //Создаем два масива для строк и чисел
        String[] words = new String[counterW];
        Integer[] numbers = new Integer[counterN];

        //Заполняем массивы
        int n = 0;
        int w = 0;
        for (String s: array){
            if (isNumber(s)){
                numbers[n] = Integer.parseInt(s); n++;
            }
            else {
                words[w] = s;
                w++;
            }
        }

        //Сортируем
        //Строки по алфавиту, обязательно с методом isGreaterThan
        for (int i=0; i<words.length; i++) {
            for (int j=0; j < words.length-1;j++) {
                if (isGreaterThan(words[j],words[j+1])){
                    String s = words[j];
                    words[j] = words[j+1];
                    words[j+1] = s;
                }
            }
        }
        //Числа по убыванию
        Arrays.sort(numbers, Comparator.reverseOrder());

        //Заполняем исходный массив
        int x = 0;
        int y = 0;
        for (int i = 0; i < array.length; i++) {
            if (isNumber(array[i])){
                array[i] = Integer.toString(numbers[x]);
                x++;
            }
            else{
                array[i] = words[y];
                y++;
            }
        }
    }

    // Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }


    // Переданная строка - это число?
    public static boolean isNumber(String s) {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') // есть '-' внутри строки
                    || (!Character.isDigit(c) && c != '-')) // не цифра и не начинается с '-'
            {
                return false;
            }
        }
        return true;
    }
}
