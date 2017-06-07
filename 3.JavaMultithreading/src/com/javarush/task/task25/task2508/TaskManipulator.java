package com.javarush.task.task25.task2508;

public class TaskManipulator implements Runnable, CustomThreadManipulator {
    // Класс TaskManipulator должен иметь внутреннее поле типа Thread.
    private Thread thread;

    // Метод run должен каждые 100 миллисекунд выводить имя исполняемой нити в консоль.
    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName());
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    // Метод start должен создавать, сохранять во внутреннее поле и запускать нить с именем,
    // которое передано через аргумент метода.
    @Override
    public void start(String threadName) {
        thread = new Thread(this, threadName);
        thread.start();
    }

    // Метод stop должен прерывать последнюю созданную классом TaskManipulator нить.
    @Override
    public void stop() {
        thread.interrupt();
    }
}
