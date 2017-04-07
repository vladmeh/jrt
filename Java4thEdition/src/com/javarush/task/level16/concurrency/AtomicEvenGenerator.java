package com.javarush.task.level16.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Атомарные классы иногда используются в обычном коде.
 * {RunByHand}
 */
public class AtomicEvenGenerator extends IntGenerator{
    private AtomicInteger currentEvenValue =
            new AtomicInteger(0);
    public int next() {
        return currentEvenValue.addAndGet(2);
    }
    public static void main(String[] args) {
        EvenChecker.test(new AtomicEvenGenerator());
    }
}
