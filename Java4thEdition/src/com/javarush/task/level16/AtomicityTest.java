package com.javarush.task.level16;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AtomicityTest implements Runnable{
    private int i = 0;
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        AtomicityTest at = new AtomicityTest();
        exec.execute(at);
        while (true) {
            int val = at.getValue();
            if (val % 2 != 0) {
                System.out.println(val);
                System.exit(0);
            }
        }
    }
    private synchronized void evenIncrement(){
        i++;
        i++;
    }

    public void run() {
        while (true){
            evenIncrement();
        }
    }

    public int getValue() {
        return i;
    }
}
