package com.javarush.task.level16;

/**
 * Конфликт потоков.
 */
public class EvenGenerator extends IntGenerator{
    private int currentEvenValue = 0;
    public int next() {
        ++currentEvenValue;  // Опасная точка!
        Thread.yield(); // Ускоряем сбой
        ++currentEvenValue;
        return currentEvenValue;
    }
    public static void main(String[] args) {
        EvenChecker.test(new EvenGenerator());
    }
}
