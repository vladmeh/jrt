package com.javarush.task.task16.task1616;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Считаем секунды

1. Напиши реализацию метода run в нити Stopwatch (секундомер).
2. Stopwatch должен посчитать количество секунд, которое прошло от создания нити до ввода строки.
3. Выведи количество секунд в консоль.


Требования:
1. Метод run класса Stopwatch (секундомер) должен содержать цикл.
2. Метод run должен вызывать Thread.sleep(1000).
3. Метод run должен увеличивать значение поля seconds на 1 каждую секунду.
4. После прерывания работы нити Stopwatch (вызова метода interrupt), метод run должен вывести количество секунд (seconds) в консоль.
5. В классе Stopwatch должен быть только один метод run.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);
        //create and run thread
        //сщздаем и запускаем поток
        Stopwatch stopwatch = new Stopwatch();
        stopwatch.start();
        //read a string
        //считываем строку
        reader.readLine();

        //ЗАВЕРШАЕМ RUN
        stopwatch.interrupt();
        //close streams
        reader.close();
        in.close();
    }

    public static class Stopwatch extends Thread {
        private int seconds;

        public void run() {
            try {
                //add your code here - добавьте код тут
                //получаем объект вызвавшей его нити
                Thread current = Thread.currentThread();
                //пока переменная isInterrupt текущей нити равна false
                while (!current.isInterrupted())
                {
                    seconds++;
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                System.out.println(seconds);
            }
        }
    }
}
