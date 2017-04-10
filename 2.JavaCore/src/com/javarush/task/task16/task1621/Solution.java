package com.javarush.task.task16.task1621;

/* 
Thread.currentThread - всегда возвращает текущую нить

Thread.currentThread - всегда возвращает текущую нить
1. В методе printMsg присвой переменной t текущую нить.
2. В методе printMsg после всех действий поставь задержку в 1 миллисекунду.


Требования:
1. Метод printMsg должен получать текущую нить с помощью Thread.currentThread.
2. Метод printMsg должен должен усыплять нить на 1 миллисекунду.
3. Метод printMsg должен вызывать метод getName у текущей нити.
4. Метод main должен вызвать метод printMsg у объекта типа NameOfDifferentThreads 5 раз.
5. Метод run должен вызвать метод printMsg 5 раз.
6. Метод printMsg у объекта типа NameOfDifferentThreads суммарно должен быть вызван 10 раз.
*/

public class Solution {
    static int count = 5;

    public static void main(String[] args) {
        NameOfDifferentThreads tt = new NameOfDifferentThreads();
        tt.start();
        for (int i = 0; i < count; i++) {
            tt.printMsg();
        }
    }

    public static class NameOfDifferentThreads extends Thread {
        public void run() {
            for (int i = 0; i < count; i++) {
                printMsg();
            }
        }

        public void printMsg() {
            try {
                Thread t = Thread.currentThread();//присвой переменной t текущую нить
                String name = t.getName();
                System.out.println("name=" + name);
                //add sleep here - добавь sleep тут
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
