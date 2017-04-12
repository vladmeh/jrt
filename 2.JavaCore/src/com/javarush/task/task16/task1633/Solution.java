package com.javarush.task.task16.task1633;


/**
 * Отдебажим все на свете
 Разобраться, что делает программа.
 Почитать про UncaughtExceptionHandler - это важно.
 Еще раз внимательно посмотреть программу.
 Разобраться - продебажить - почему наш OurUncaughtExceptionHandler не срабатывает.
 Исправить ошибку, т.е. все должно работать. :)
 Ожидаемый результат в произвольном порядке:
 Нить 1: My exception message
 Нить 2: My exception message

 Требования:
 1. Метод main должен создавать нить с параметрами: commonThread и "Нить 1".
 2. Метод main должен создавать нить с параметрами: commonThread и "Нить 2".
 3. Метод main должен запускать две созданные нити типа Thread.
 4. Метод main должен прерывать две созданные нити типа Thread.
 5. Программа с помощью метода uncaughtException класса OurUncaughtExceptionHandler должна вывести 2 сообщения.
 6. Метод uncaughtException класса OurUncaughtExceptionHandler явно не вызывать.
 7. Вывод программы должен содержать строки: "Нить 1: My exception message" и "Нить 2: My exception message".


 */


public class Solution {
    //содаётся объект, который будет обрабатывать наши исключения
    public static Thread.UncaughtExceptionHandler handler = new OurUncaughtExceptionHandler();

    public static void main(String[] args) {
        // создаётся объект TestedTread
        // в конструкторе устанавливается наш handler, и если бы нитка прерывалась, то он бы сработал.
        // Но нитка не прерывается, эксцепшена не выбрасывается, и handler тут остаётся за кадром.
        TestedThread commonThread = new TestedThread(handler);

        // Создаются две нитки, но они имеют тип просто Thread, а не наш переопределенный TestedThread,
        // потому им переданный в конструктор commonThread "до лампочки" в части отлова исключений,
        // они ничего не знают про наш конструктор TestedThread, и потому hadler просто не видят,
        // соответственно обрабатывают исключения, как умеют, по своему, классом Thread
        Thread threadA = new Thread(commonThread, "Нить 1");
        Thread threadB = new Thread(commonThread, "Нить 2");


        // Что можно сделать:
        // 1. "Определить свой класс ThreadGroup и переопределить метод uncaughtException()." - это нельзя
        // т.к. наши нити просто нити по условиям задачи.
        //
        // 2. Вызвать статический метод класса Thread - setDefaultUncaughtExceptionHandler().
        // Это можно. Если вызовем и туда пихнём наш хэндлер, то все нити будут именно им пользоваться.
        // В реальном проекте нафиг-нафиг. Но знать полезно.
        //
        // 3. Вызвать метод setUncaughtExceptionHandler() у ОБЪЕКТА класса Thread. - Вот, то что нужно.
        // Берем наши нитки, и каждой через эту функцию посылаем приветик, в виде handler,
        // чтобы она знала как обрабатывать такие эксцепшены.
        threadA.setUncaughtExceptionHandler(handler);
        threadB.setUncaughtExceptionHandler(handler);

        threadA.start();
        threadB.start();

        threadA.interrupt();
        threadB.interrupt();
    }

    public static class TestedThread extends Thread {
        public TestedThread(Thread.UncaughtExceptionHandler handler) {
            setUncaughtExceptionHandler(handler);
            start();
        }

        public void run() {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException x) {
                throw new RuntimeException("My exception message");
            }
        }
    }

    public static class OurUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
        @Override
        public void uncaughtException(Thread t, Throwable e) {
            System.out.println(t.getName() + ": " + e.getMessage());
        }
    }
}
