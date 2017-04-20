package com.javarush.task.level16;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Кажущиеся безопасными операции с появлением потоков
 * перестают быть таковыми...
 * {Args: 4}
 */
public class SerialNumberChecker {
    private static final int SIZE = 10;
    private static CircularSet serials = new CircularSet(1000);
    private static ExecutorService exec = Executors.newCachedThreadPool();

    static class SerialChecker implements Runnable{
        @Override
        public void run() {
            while (true) {
                int serial = SerialNumberGenerator.nextSerialNumber();

                if(serials.contains(serial)){
                    System.out.println("Duplicate: " + serial);
                    System.exit(0);
                }
                serials.add(serial);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for(int i = 0; i < SIZE; i++)
            exec.execute(new SerialChecker());
        // Остановиться после n секунд при наличии аргумента:
        if(args.length > 0) {
            TimeUnit.SECONDS.sleep(new Integer(args[0]));
            System.out.println("No duplicates detected");
            System.exit(0);
        }
    }
}

// Reuses storage so we don't run out of memory:
class CircularSet {
    private int[] array;
    private int len;
    private int index = 0;
    public CircularSet(int size) {
        array = new int[size];
        len = size;
        // Инициализируем значением, которое не производится
        // классом SerialNumberGenerator:
        for(int i = 0; i < size; i++)
            array[i] = -1;
    }
    public synchronized void add(int i) {
        array[index] = i;
        // Возврат индекса к началу с записью поверх старых значений:
        index = ++index % len;
    }
    public synchronized boolean contains(int val) {
        for(int i = 0; i < len; i++)
            if(array[i] == val) return true;
        return false;
    }
}