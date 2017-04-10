package com.javarush.task.task16.task1626;


/**
 * Создание по образцу
 *
 * Разберись, как работает программа.
 * По образу и подобию CountDownRunnable создай нить CountUpRunnable, которая выводит значения в нормальном порядке — от 1 до number.
 * Требования:
 * 1. Класс CountUpRunnable должен реализовывать интерфейс Runnable.
 * 2. Класс CountUpRunnable должен иметь публичный метод run без параметров.
 * 3. Метод run класса CountUpRunnable должен работать примерно 2,5 секунды.
 * 4. Метод run класса CountUpRunnable должен каждые полсекунды выводить имя потока, двоеточие и значение счетчика от 1 до 5 (например: "Увеличиваем: 1").
 * 5. Метод run класса CountUpRunnable должен вызывать Thread.sleep(500).
 */
public class Solution {
    public static int number = 5;

    public static void main(String[] args) {
        new Thread(new CountDownRunnable(), "Уменьшаем").start();
        new Thread(new CountUpRunnable(), "Увеличиваем").start();
    }

    public static class CountUpRunnable implements Runnable{
        private int coutnIndexUp = 0;

        @Override
        public void run() {
            try{
                while (true) {
                    coutnIndexUp += 1;
                    System.out.println(toString());
                    //Метод run класса CountUpRunnable должен работать примерно 2,5 секунды.
                    Thread.sleep(500);
                    if (coutnIndexUp == Solution.number)
                        return;

                    //Если задержку ставить здесь, то методбудет работать на 500 мс меньше
                    //Условие "Метод run класса CountUpRunnable должен работать примерно 2,5 секунды"
                    //не выполняется
                }
            } catch (InterruptedException e) {
            }
        }

        @Override
        public String toString() {
            return String.format("%s: %d", Thread.currentThread().getName(), coutnIndexUp);
        }
    }


    public static class CountDownRunnable implements Runnable {
        private int countIndexDown = Solution.number;

        public void run() {
            try {
                while (true) {
                    System.out.println(toString());
                    countIndexDown -= 1;
                    if (countIndexDown == 0) return;
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
            }
        }

        public String toString() {
            return Thread.currentThread().getName() + ": " + countIndexDown;
        }
    }
}
