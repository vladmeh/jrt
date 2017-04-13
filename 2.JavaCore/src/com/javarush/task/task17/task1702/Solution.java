package com.javarush.task.task17.task1702;

import java.util.ArrayList;
import java.util.List;

/* 
Вместе быстрее? Ща проверим :)

1. Разберись, что и как работает.
2. Создай public static нить SortThread, которая в методе run отсортирует статический массив testArray используя метод sort.


Требования:
1. Класс Solution должен содержать public static класс SortThread.
2. Класс SortThread должен быть нитью.
3. В методе run класса SortThread должен вызывать метод sort() с параметром testArray.
4. Программа должна выводить текст на экран.


Программа асинхронно запускает 10 нитей, которые сортируют массив.
Результат сортировки сравнивается с шаблоном и выводится на консоль
*/

public class Solution {
    //статическая переменная целочисленного типа счетчика нитей
    public static int countThreads = 10;
    //статическая переменная тестового массива
    public static int[] testArray = new int[1000];

    //В статическом блоке заполняем массив индексами
    static {
        for (int i = 0; i < Solution.testArray.length; i++) {
            testArray[i] = i;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //создаем объект типа StringBuffer и присваиваем его переменной
        StringBuffer expectedResult = new StringBuffer();
        //создаем строку с числами от 999 -> 0 c пробелами
        for (int i = 1000 - 1; i >= 0; i--) {
            expectedResult.append(i).append(" ");
        }

        //запускаем метод
        initThreads();

        //создаем объект типа StringBuffer и присваиваем его переменной
        StringBuffer result = new StringBuffer();
        //создаем строку cо значениями из массива c пробелами
        for (int i = 0; i < testArray.length; i++) {
            result.append(testArray[i]).append(" ");
        }
        //Выводим результат сортировки массива на консоль
        System.out.println(result);
        //Сравниваем результат сортировки массива со строкой
        System.out.println((result.toString()).equals(expectedResult.toString()));
    }


    /**
     * Метод инициализирующий нити SortThread
     *
     * @throws InterruptedException
     */
    public static void initThreads() throws InterruptedException {
        //создаем список в котором будем хранить нити
        List<Thread> threads = new ArrayList<Thread>(countThreads);
        //добавляем в список 10 нитей SortThread
        for (int i = 0; i < countThreads; i++) threads.add(new SortThread());
        //Запускаем все нити
        for (Thread thread : threads) thread.start();
        //Приостанавливаем все нити
        for (Thread thread : threads) thread.join();
    }

    /**
     * Метод сортировки массива по убыванию (пузырьком)
     *
     * @param array
     */
    public static void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] < array[j]) {
                    int k = array[i];
                    array[i] = array[j];
                    array[j] = k;
                }
            }
        }
    }

    /**
     * Нить вызывающая метод sort c параметром testArray
     */
    public static class SortThread extends Thread {
        @Override
        public void run() {
            sort(testArray);
        }
    }
}

