package com.javarush.task.task25.task2504;

/* 
Switch для нитей
*/
public class Solution {
    public static void processThreads(Thread... threads) {
        //implement this method - реализуйте этот метод
        for (Thread thread: threads){
            switch (thread.getState()) {
                //новая нить
                case NEW:
                    thread.start(); //стартуем
                    break;

                //нить в ожидании
                case WAITING:
                case TIMED_WAITING:
                case BLOCKED:
                    thread.interrupt(); //прерываем
                    break;

                //нить работает
                case RUNNABLE:
                    thread.isInterrupted(); //проверяем маркер состояния
                    break;

                //нить прекратила работу
                case TERMINATED:
                    System.out.println(thread.getPriority()); //печатаем приоритет (int)
            }
        }
    }

    public static void main(String[] args) {
    }
}
