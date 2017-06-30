package com.javarush.task.task27.task2712;

import java.util.List;

/**
 * @autor mvl on 30.06.2017.
 */
public class RandomOrderGeneratorTask implements Runnable {
    private List<Tablet> tablets;
    private int interval;

    public RandomOrderGeneratorTask(List<Tablet> tablets, int interval) {
        this.tablets = tablets;
        this.interval = interval;
    }

    @Override
    public void run() {
        if (tablets.isEmpty()) return;

        try {
            while (!Thread.currentThread().isInterrupted()) {
                Tablet tablet = tablets.get((int) (Math.random() * tablets.size()));
                tablet.createOrder();
                Thread.sleep(interval);
            }
        } catch (InterruptedException e) {
        }
    }
}
