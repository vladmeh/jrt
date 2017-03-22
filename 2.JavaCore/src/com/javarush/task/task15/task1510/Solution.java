package com.javarush.task.task15.task1510;

/* 
Все лишнее - прочь!
Убрать в методе main лишние строки, для которых метод add не реализован.
*/

public class Solution {
    public static void main(String[] args) {
        add((short) 1, 2f); //short->int, float->dooble +
        add(1, 2); //int, int +
        add(2d, 2); //dooble, int->dooble +
        //add("1",2d); //Параметр String "1" ни где не рализован -
        add((byte) 1, 2d); //byte->int, dooble +
    }

    public static void add(int i, int j) {
        System.out.println("Integer addition");
    }

    public static void add(int i, double j) {
        System.out.println("Integer and double addition");
    }

    public static void add(double i, double j) {
        System.out.println("Double addition");
    }
}
