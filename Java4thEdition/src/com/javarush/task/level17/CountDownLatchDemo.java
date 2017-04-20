package com.javarush.task.level17;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static net.mindview.util.Print.print;

/**
 * The type Count down latch demo.
 * TaskPortion некоторое время ожидает, имитируя выполнение части задачи,
 * а класс WaitingTask представляет некую часть системы, которая обязана
 * дождаться завершения всех подзадач.
 *
 * Все задачи используют один и тот же объект CountDownLatch, определяемый в main().
 */
public class CountDownLatchDemo {
    /**
     * The Size.
     */
    static final int SIZE = 100;

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws Exception the exception
     */
    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        // Все подзадачи совместно используют один объект CountDownLatch:
        CountDownLatch latch = new CountDownLatch(SIZE);
        for(int i = 0; i < 10; i++)
            exec.execute(new WaitingTask(latch));
        for(int i = 0; i < SIZE; i++)
            exec.execute(new TaskPortion(latch));
        print("Launched all tasks");
        exec.shutdown(); // Выход по завершению всех задач
    }
}

/**
 * The type Task portion.
 */
// Часть основной задачи.:
class TaskPortion implements Runnable {
    private static int counter = 0;
    private final int id = counter++;
    private static Random rand = new Random(47);
    private final CountDownLatch latch;

    /**
     * Instantiates a new Task portion.
     *
     * @param latch the latch
     */
    TaskPortion(CountDownLatch latch) {
        this.latch = latch;
    }

    public void run() {
        try {
            doWork();
            latch.countDown();
        } catch(InterruptedException ex) {
            // Приемлемый вариант выхода
        }
    }

    /**
     * Do work.
     *
     * @throws InterruptedException the interrupted exception
     */
    public void doWork() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(rand.nextInt(2000));
        print(this + "completed");
    }

    public String toString() {
        return String.format("%1$-3d ", id);
    }
}

/**
 * The type Waiting task.
 */
// Ожидание по объекту CountDownLatch:
class WaitingTask implements Runnable {
    private static int counter = 0;
    private final int id = counter++;
    private final CountDownLatch latch;

    /**
     * Instantiates a new Waiting task.
     *
     * @param latch the latch
     */
    WaitingTask(CountDownLatch latch) {
        this.latch = latch;
    }

    public void run() {
        try {
            latch.await();
            print("Latch barrier passed for " + this);
        } catch(InterruptedException ex) {
            print(this + " interrupted");
        }
    }

    public String toString() {
        return String.format("WaitingTask %1$-3d ", id);
    }
}