package com.javarush.task.level16.concurrency;

/**
 * Упрощение работы с мьютексами с использованием
 * ключевого слова synchronized.
 * {RunByHand}
 */
public class SynchronizedEvenGenerator extends IntGenerator {
    private int currentEvenValue = 0;
    public synchronized int next() {
        ++currentEvenValue;
        Thread.yield(); // Ускоряем сбой
        ++currentEvenValue;
        return currentEvenValue;
    }
    public static void main(String[] args) {
        EvenChecker.test(new SynchronizedEvenGenerator());
    }
}
