package com.javarush.task.level16;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * Created by mvl on 05.04.2017.
 */

class TaskWithResult implements Callable<String> {
    private int id;
    public TaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        return "result of TaskWithResult " + id;
    }
}

public class CallableDemo {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();

        ArrayList<Future<String>> results = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            results.add(exec.submit(new TaskWithResult(i)));
        }

        for (Future<String> fs : results)
            try {
                // Вызов get() блокируется до завершения;:
                System.out.println(fs.get());
            } catch(InterruptedException e) {
                System.out.println(e);
                return;
            } catch(ExecutionException e) {
                System.out.println(e);
            } finally {
                exec.shutdown();
            }
    }
}
