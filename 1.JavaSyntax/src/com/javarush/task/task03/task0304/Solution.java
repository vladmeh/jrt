package com.javarush.task.task03.task0304;

/* 
Задача на проценты
Реализуй метод addTenPercent, который увеличивает переданное целое число на 10%.
Исправь ошибку в сигнатуре метода.

Подсказка:
подумай, какие у этого метода входные и выходные данные.
*/

public class Solution {
    public static double addTenPercent(int i) {
        double k = i * 0.1;
        return i + k;
    }

    public static void main(String[] args) {
        System.out.println(addTenPercent(9));
    }
}
