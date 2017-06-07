package com.javarush.task.task25.task2510;

/* 
Поживем - увидим
*/
public class Solution extends Thread {

    public Solution() {
        this.setUncaughtExceptionHandler(
                (t, e) -> {
                    if (e instanceof Error)
                        System.out.println("Нельзя дальше работать");

                    else if (e instanceof  Exception)
                        System.out.println("Надо обработать");

                    else if (e != null)
                        System.out.println("ХЗ");
                });
    }

    public static void main(String[] args) {
    }
}
