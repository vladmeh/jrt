package com.javarush.task.task16.task1603;

import java.util.ArrayList;
import java.util.List;

/* 
Список и нити

В методе main добавить в статический объект list 5 нитей. Каждая нить должна быть новым объектом класса Thread, работающим со своим объектом класса SpecialThread.


Требования:
1. В методе main создай 5 объектов типа SpecialThread.
2. В методе main создай 5 объектов типа Thread.
3. Добавь 5 разных нитей в список list.
4. Каждая нить из списка list должна работать со своим объектом класса SpecialThread.
5. Метод run класса SpecialThread должен выводить "it's a run method inside SpecialThread".
*/

public class Solution {
    public static volatile List<Thread> list = new ArrayList<Thread>(5);

    public static void main(String[] args) {
        //Создаем объект типа SpecialThread
        SpecialThread o1 = new SpecialThread();
        //Создаем нить (объект типа Thread) на основе объекта o1
        Thread n1 = new Thread(o1);
        //Добавляем нить (поток) в list
        list.add(n1);

        //и т.д.
        for (int i = 0; i < 4; i++) {
            list.add(new Thread(new SpecialThread()));
        }
    }

    public static class SpecialThread implements Runnable {
        public void run() {
            System.out.println("it's a run method inside SpecialThread");
        }
    }
}
