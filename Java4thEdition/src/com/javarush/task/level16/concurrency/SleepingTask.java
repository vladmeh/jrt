package com.javarush.task.level16.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by mvl on 05.04.2017.
 */
public class SleepingTask extends LiftOff {
    @Override
    public void run() {
        try{
            while (countDown-- > 0){
                System.out.print(status());
                // Старый стиль.
                // Thread.sleep(l00);
                // Стиль Java SE5/6:
                TimeUnit.SECONDS.sleep(1);
            }
        } catch (InterruptedException e) {
            System.err.println("Interrupted");
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();

        for (int i = 0; i < 5; i++) {
            exec.execute(new SleepingTask());
        }

        exec.shutdown();
    }
}
