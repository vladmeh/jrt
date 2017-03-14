package com.javarush.task.task13.task1308;

/* 
Жив или нет
*/

public class Solution {
    public static void main(String[] args) throws Exception {
    }

    interface Person{
        boolean isAlive();
    }

    interface Presentable extends Person{}
}