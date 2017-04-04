package com.javarush.task.task08.task0825;

/* 
Модификатор запутался

Переставь один модификатор static, чтобы пример скомпилировался.


Требования:
1. Программа не должна считывать данные с клавиатуры.
2. В классе Solution должна быть переменная A.
3. В классе Solution должна быть переменная B.
4. В классе Solution должна быть переменная C.
5. В классе Solution должна быть переменная D.
6. Класс Solution должен содержать только три метода.
7. В классе должно быть 4 статика (переменные и методы).
*/

public class Solution {
    public static int A = 5;
    public static int B = 2;

    public int C = A * B;
    public static int D = B * A;

    public static void main(String[] args) {
    }

    public  int getValue() {
        return D;
    }

    public int getValue2() {
        return C;
    }
}

