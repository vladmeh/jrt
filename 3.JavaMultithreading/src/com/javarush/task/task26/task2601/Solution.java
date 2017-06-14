package com.javarush.task.task26.task2601;

import java.util.Arrays;

/*
Почитать в инете про медиану выборки
*/
public class Solution {
    public static void main(String[] args) {

    }

    public static Integer[] sort(Integer[] array) {
        Arrays.sort(array);

        int i_middle = array.length/2;
        final double mediana = (array.length % 2 == 1) ? array[i_middle] : (array[i_middle - 1] + array[i_middle]) / 2;

        Arrays.sort(array, (o1, o2) -> {
            int result = (int)Math.round(Math.abs(mediana - o1) - Math.abs(mediana - o2));
            return (result == 0) ? (o1 - o2) : result;
        });

        return array;
    }
}
