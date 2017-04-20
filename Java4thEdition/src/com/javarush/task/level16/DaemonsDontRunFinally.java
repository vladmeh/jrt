package com.javarush.task.level16;

import java.util.concurrent.TimeUnit;

import static net.mindview.util.Print.print;

/**
 * Потоки-демоны не выполняют секцию finally.
 */
public class DaemonsDontRunFinally {
    public static void main(String[] args) {
        Thread t = new Thread(new ADaemon());
        //если закомментировать вызов setDaemon(), секция finally была выполнена
        //t.setDaemon(true);
        t.start();
    }
}

class ADaemon implements Runnable {
    public void run() {
        try {
            print("Starting ADaemon");
            TimeUnit.SECONDS.sleep(1);
        } catch(InterruptedException e) {
            print("Exiting via InterruptedException");
        } finally {
            print("This should always run?");
        }
    }
}
