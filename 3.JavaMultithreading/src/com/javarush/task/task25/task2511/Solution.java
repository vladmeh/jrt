package com.javarush.task.task25.task2511;

import java.util.TimerTask;

/* 
Вооружаемся до зубов!
*/
public class Solution extends TimerTask {
    protected TimerTask original;
    protected final Thread.UncaughtExceptionHandler handler;

    public Solution(TimerTask original) {
        if (original == null) {
            throw new NullPointerException();
        }
        this.original = original;
        //this.handler = null;

        this.handler = (t, e) -> {
            String name = t.getName();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < name.length(); i++) {
                sb.append('*');
            }
            String newName = sb.toString();
            String msg = e.getMessage().replaceAll(t.getName(),newName);
            e = new Exception(msg, e);
            System.out.println(e.getMessage());
            t.setName(newName);
        };
        //init handler here
    }

    public void run() {
        try {
            original.run();
        } catch (Throwable cause) {
            Thread currentThread = Thread.currentThread();
            handler.uncaughtException(currentThread, new Exception("Blah " + currentThread.getName() + " blah-blah-blah", cause));
        }
    }

    public long scheduledExecutionTime() {
        return original.scheduledExecutionTime();
    }

    public boolean cancel() {
        return original.cancel();
    }

    public static void main(String[] args) {

    }
}