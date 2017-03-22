package com.javarush.task.task03.task0306;

/* 
Головоломка со скобками
Расставить правильно (по другому) скобки, чтобы на экран вывелось число 850
1 + 2 * 3 + 4 * 5 + 6 * 7 + 8 * 9 + 10 * 11 + 12 * 13 + 14 + 15
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(1 + 2 * (3 + 4 * 5 + 6 * 7 + 8 * 9 + 10 * 11 + 12 * 13 + 14) + 15);
    }
}
