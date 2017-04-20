package com.javarush.task.level17;


import java.util.concurrent.*;
import java.util.*;
import static net.mindview.util.Print.*;

/**
 * The type Prioritized task.
 */
class PrioritizedTask implements
        Runnable, Comparable<PrioritizedTask>  {
    private Random rand = new Random(47);
    private static int counter = 0;
    private final int id = counter++;
    private final int priority;
    /**
     * The constant sequence.
     */
    protected static List<PrioritizedTask> sequence =
            new ArrayList<PrioritizedTask>();

    /**
     * Instantiates a new Prioritized task.
     *
     * @param priority the priority
     */
    public PrioritizedTask(int priority) {
        this.priority = priority;
        sequence.add(this);
    }
    public int compareTo(PrioritizedTask arg) {
        return priority < arg.priority ? 1 :
                (priority > arg.priority ? -1 : 0);
    }
    public void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(rand.nextInt(250));
        } catch(InterruptedException e) {
            // Приемлемый вариант выхода
        }
        print(this);
    }
    public String toString() {
        return String.format("[%1$-3d]", priority) +
                " Task " + id;
    }

    /**
     * Summary string.
     *
     * @return the string
     */
    public String summary() {
        return "(" + id + ":" + priority + ")";
    }

    /**
     * The type End sentinel.
     */
    public static class EndSentinel extends PrioritizedTask {
        private ExecutorService exec;

        /**
         * Instantiates a new End sentinel.
         *
         * @param e the e
         */
        public EndSentinel(ExecutorService e) {
            super(-1); // Минимальный приоритет в этой программе
            exec = e;
        }
        public void run() {
            int count = 0;
            for(PrioritizedTask pt : sequence) {
                printnb(pt.summary());
                if(++count % 5 == 0)
                    print();
            }
            print();
            print(this + " Calling shutdownNow()");
            exec.shutdownNow();
        }
    }
}

/**
 * The type Prioritized task producer.
 */
class PrioritizedTaskProducer implements Runnable {
    private Random rand = new Random(47);
    private Queue<Runnable> queue;
    private ExecutorService exec;

    /**
     * Instantiates a new Prioritized task producer.
     *
     * @param q the q
     * @param e the e
     */
    public PrioritizedTaskProducer(
            Queue<Runnable> q, ExecutorService e) {
        queue = q;
        exec = e; // Используется для EndSentinel
    }
    public void run() {
        // Неограниченная очередь без блокировки.
        // Быстрое заполнение случайными приоритетами:
        for(int i = 0; i < 20; i++) {
            queue.add(new PrioritizedTask(rand.nextInt(10)));
            Thread.yield();
        }
        // Добавление высокоприоритетных задач:
        try {
            for(int i = 0; i < 10; i++) {
                TimeUnit.MILLISECONDS.sleep(250);
                queue.add(new PrioritizedTask(10));
            }
            // Добавление заданий, начиная с наименьших приоритетов:
            for(int i = 0; i < 10; i++)
                queue.add(new PrioritizedTask(i));
            // Предохранитель для остановки всех задач::
            queue.add(new PrioritizedTask.EndSentinel(exec));
        } catch(InterruptedException e) {
            // Приемлемый вариант выхода
        }
        print("Finished PrioritizedTaskProducer");
    }
}

/**
 * The type Prioritized task consumer.
 */
class PrioritizedTaskConsumer implements Runnable {
    private PriorityBlockingQueue<Runnable> q;

    /**
     * Instantiates a new Prioritized task consumer.
     *
     * @param q the q
     */
    public PrioritizedTaskConsumer(
            PriorityBlockingQueue<Runnable> q) {
        this.q = q;
    }
    public void run() {
        try {
            while(!Thread.interrupted())
                // Использование текущего потока для запуска задачи:
                q.take().run();
        } catch(InterruptedException e) {
            // Приемлемый вариант выхода
        }
        print("Finished PrioritizedTaskConsumer");
    }
}

/**
 * The type Priority blocking queue demo.
 */
public class PriorityBlockingQueueDemo {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws Exception the exception
     */
    public static void main(String[] args) throws Exception {
        Random rand = new Random(47);
        ExecutorService exec = Executors.newCachedThreadPool();
        PriorityBlockingQueue<Runnable> queue =
                new PriorityBlockingQueue<Runnable>();
        exec.execute(new PrioritizedTaskProducer(queue, exec));
        exec.execute(new PrioritizedTaskConsumer(queue));
    }
}