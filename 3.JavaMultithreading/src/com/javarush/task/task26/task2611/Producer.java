package com.javarush.task.task26.task2611;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @autor mvl on 14.06.2017.
 */
public class Producer implements Runnable {
    private ConcurrentHashMap<String, String> map;

    public Producer(ConcurrentHashMap<String, String> map) {
        this.map = map;
    }

    @Override
    public void run() {
        Thread currentThread = Thread.currentThread();
        int i = 0;
        while (!currentThread.isInterrupted()) {
            i++;
            try {
                map.put(String.valueOf(i), "Some text for " + i);
                Thread.sleep(500);
            } catch (Exception e) {
                System.out.println(String.format("[%s] thread was terminated", currentThread.getName()));
            }
        }
    }
}
