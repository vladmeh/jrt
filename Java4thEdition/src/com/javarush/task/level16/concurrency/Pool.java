package com.javarush.task.level16.concurrency;

/**
 * Использование Semaphore в Pool ограничивает количество
 * задач, которые могут использовать ресурс.
 */
import java.util.concurrent.*;
import java.util.*;

public class Pool<T> {
    private int size;
    private List<T> items = new ArrayList<T>();
    private volatile boolean[] checkedOut;
    private Semaphore available;
    public Pool(Class<T> classObject, int size) {
        this.size = size;
        checkedOut = new boolean[size];
        available = new Semaphore(size, true);
        // Заполнение пула объектами :
        for(int i = 0; i < size; ++i)
            try {
                // Предполагается наличие конструктора по умолчанию:
                items.add(classObject.newInstance());
            } catch(Exception e) {
                throw new RuntimeException(e);
            }
    }
    public T checkOut() throws InterruptedException {
        available.acquire();
        return getItem();
    }
    public void checkIn(T x) {
        if(releaseItem(x))
            available.release();
    }
    private synchronized T getItem() {
        for(int i = 0; i < size; ++i)
            if(!checkedOut[i]) {
                checkedOut[i] = true;
                return items.get(i);
            }
        return null;  // Семафор предотвращает переход в зту точку
    }
    private synchronized boolean releaseItem(T item) {
        int index = items.indexOf(item);
        if(index == -1) return false; // Отсутствует в списке
        if(checkedOut[index]) {
            checkedOut[index] = false;
            return true;
        }
        return false; // He был освобожден
    }
}
