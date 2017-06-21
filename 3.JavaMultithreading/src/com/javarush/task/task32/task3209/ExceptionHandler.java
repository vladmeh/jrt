package com.javarush.task.task32.task3209;

/**
 * @autor mvl on 21.06.2017.
 */
public class ExceptionHandler extends Exception{
    public static void log(Exception e){
        System.out.println(e.toString());
    }
}
