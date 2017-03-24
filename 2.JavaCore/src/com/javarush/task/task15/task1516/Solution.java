package com.javarush.task.task15.task1516;

/* 
Значения по-умолчанию

1. Создать 7 public полей класса. Убедитесь, что они инициализируются дефолтными значениями.
intVar типа int
doubleVar типа double
DoubleVar типа Double
booleanVar типа boolean
ObjectVar типа Object
ExceptionVar типа Exception
StringVar типа String
2. В методе main вывести их значения в заданном порядке.
*/

public class Solution {

    public int intVar; //дефолтное значение 0
    public double doubleVar; //0.0
    public Double DoubleVar; //null
    public boolean booleanVar; //false
    public Object ObjectVar; //null
    public Exception ExceptionVar; //null
    public String StringVar; //null

    public static void main(String[] args) {
        /*
            Т.к. в классе не определены констукторы, автоматически создается конструктор без
            аргументов который загружается первый и ничего не знает про наши переменные.
            Для доступа к полям нужно сначала создать экземпляр класса:
         */
        System.out.println(new Solution().intVar);
        System.out.println(new Solution().doubleVar);
        System.out.println(new Solution().DoubleVar);
        System.out.println(new Solution().booleanVar);
        System.out.println(new Solution().ObjectVar);
        System.out.println(new Solution().ExceptionVar);
        System.out.println(new Solution().StringVar);
    }
}
