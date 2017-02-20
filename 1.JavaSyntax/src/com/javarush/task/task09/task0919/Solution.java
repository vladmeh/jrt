package com.javarush.task.task09.task0919;

/* 
Деление на ноль
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        try{
            divisionByZero();
        }
        catch (ArithmeticException e){
            e.printStackTrace();
        }

    }

    public static void divisionByZero() {
        int a = 5/0;
        System.out.println(a);
    }
}
