package com.javarush.task.level17;

import java.util.concurrent.*;
import java.util.*;
import static java.util.concurrent.TimeUnit.*;
import static net.mindview.util.Print.*;

/**
 * The type Delayed task.
 */
class DelayedTask implements Runnable, Delayed {
    private static int counter = 0;
    private final int id = counter++;
    private final int delta;
    private final long trigger;
    /**
     * The constant sequence.
     */
    protected static List<DelayedTask> sequence = new ArrayList<DelayedTask>();

    /**
     * Instantiates a new Delayed task.
     *
     * @param delayInMilliseconds the delay in milliseconds
     */
    public DelayedTask(int delayInMilliseconds) {
        delta = delayInMilliseconds;
        trigger = System.nanoTime() +  NANOSECONDS.convert(delta, MILLISECONDS);
        sequence.add(this);
    }

    public long getDelay(TimeUnit unit) {
        return unit.convert(trigger - System.nanoTime(), NANOSECONDS);
    }

    public int compareTo(Delayed arg) {
        DelayedTask that = (DelayedTask)arg;
        if(trigger < that.trigger) return -1;
        if(trigger > that.trigger) return 1;
        return 0;
    }

    public void run() {
        printnb(this + " ");
    }

    public String toString() {
        return String.format("[%1$-4d]", delta) + " Task " + id;
    }

    /**
     * Summary string.
     *
     * @return the string
     */
    public String summary() {
        return "(" + id + ":" + delta + ")";
    }

    /**
     * The type End sentinel.
     */
    public static class EndSentinel extends DelayedTask {
        private ExecutorService exec;

        /**
         * Instantiates a new End sentinel.
         *
         * @param delay the delay
         * @param e     the e
         */
        public EndSentinel(int delay, ExecutorService e) {
            super(delay);
            exec = e;
        }

        public void run() {
            for(DelayedTask pt : sequence) {
                printnb(pt.summary() + " ");
            }
            print();
            print(this + " Calling shutdownNow()");
            exec.shutdownNow();
        }
    }
}

/**
 * The type Delayed task consumer.
 */
class DelayedTaskConsumer implements Runnable {
    private DelayQueue<DelayedTask> q;

    /**
     * Instantiates a new Delayed task consumer.
     *
     * @param q the q
     */
    public DelayedTaskConsumer(DelayQueue<DelayedTask> q) {
        this.q = q;
    }
    public void run() {
        try {
            while(!Thread.interrupted())
                q.take().run(); // Выполнение задачи в текущем потоке
        } catch(InterruptedException e) {
            // Приемлемый вариант выхода
        }
        print("Finished DelayedTaskConsumer");
    }
}

/**
 * The type Delay queue demo.
 */
public class DelayQueueDemo {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Random rand = new Random(47);
        ExecutorService exec = Executors.newCachedThreadPool();
        DelayQueue<DelayedTask> queue =
                new DelayQueue<DelayedTask>();
        // Очередь заполняется задачами со случайной задержкой:
        for(int i = 0; i < 20; i++)
            queue.put(new DelayedTask(rand.nextInt(5000)));
        // Назначение точки остановки
        queue.add(new DelayedTask.EndSentinel(5000, exec));
        exec.execute(new DelayedTaskConsumer(queue));
    }
}