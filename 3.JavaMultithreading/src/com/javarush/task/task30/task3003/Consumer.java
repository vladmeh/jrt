package com.javarush.task.task30.task3003;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;

/**
 * @autor mvl on 04.07.2017.
 */
public class Consumer implements Runnable {
    private TransferQueue<ShareItem> queue;

    public Consumer(TransferQueue<ShareItem> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(450);

            while (!Thread.currentThread().isInterrupted()) {
                System.out.format("Processing %s%n", queue.take().toString());
            }
        } catch (InterruptedException e) {}
    }
}
