package com.javarush.task.task01.task0132;

/* 
Сумма цифр трехзначного числа
Реализуй метод sumDigitsInNumber(int number).
Метод на вход принимает целое трехзначное число.
Нужно посчитать сумму цифр этого числа, и вернуть эту сумму.

Пример:
Метод sumDigitsInNumber вызывается с параметром 546.

Пример вывода:
15
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(sumDigitsInNumber(546));
    }

    public static int sumDigitsInNumber(int number) {
        int sum = 0;
        String n = Integer.toString(number);
        for (int i = 0; i < n.length(); i++) {
            //1 вариант (спорный)
            //sum += n.charAt(i) - '0';

            //2 вариант (правильный)
            sum += Character.getNumericValue(n.charAt(i));

            // 3 вариант (распространенный)
            //sum += number % 10;
            //number /= 10;
        }

        return sum;
    }

}