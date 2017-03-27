package com.javarush.task.task03.task0314;

/* 
Таблица умножения

Выведи на экран таблицу умножения 10 на 10 в следующем виде:
1 2 3 …
2 4 6 …
3 6 9 …
…
*/

public class Solution {
    public static void main(String[] args) {
        int n = 1;
        while (n < 11){
            System.out.println(n*1 + " " + n*2 + " " + n*3 + " " + n*4 + " " + n*5 + " " + n*6 + " " + n*7 + " " + n*8 + " " + n*9 + " " + n*10);
            n++;
        }
    }
}
