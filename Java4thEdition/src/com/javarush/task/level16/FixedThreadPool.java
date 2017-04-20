package com.javarush.task.level16;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by mvl on 05.04.2017.
 */
public class FixedThreadPool {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }
}
