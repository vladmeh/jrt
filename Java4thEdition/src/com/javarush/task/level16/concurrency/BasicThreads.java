package com.javarush.task.level16.concurrency;

/**
 * Простейший вариант использования класса Thread..
 */
public class BasicThreads {
    public static void main(String[] args) {
        Thread t = new Thread(new LiftOff());
        t.start();
        System.out.println("Waiting for LiftOff");
    }
}
