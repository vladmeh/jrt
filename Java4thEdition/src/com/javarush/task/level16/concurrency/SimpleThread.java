package com.javarush.task.level16.concurrency;

/**
 * Прямое наследование от класса Thread..
 */
public class SimpleThread extends Thread{
    private int countDoun = 5;
    private static int threadCount = 0;

    public SimpleThread() {
        super(Integer.toString(++threadCount));
        start();
    }

    // Чтобы задать объектам Thread имена, вы вызываете соответствующий конструктор Thread.
    // Имя читается в методе toString() при помощи getName().
    public String toString() {
        return "#" + getName() + "(" + countDoun + "), ";
    }

    @Override
    public void run() {
        while (true){
            System.out.print(this);
            if (--countDoun == 0)
                return;
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new SimpleThread();
        }
    }
}
