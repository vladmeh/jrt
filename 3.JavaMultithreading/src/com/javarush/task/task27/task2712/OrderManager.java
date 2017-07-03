package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Order;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @autor mvl on 03.07.2017.
 */
public class OrderManager implements Observer {
    private LinkedBlockingQueue<Order> orderQueue = new LinkedBlockingQueue<>();

    @Override
    public void update(Observable o, Object arg) {
        try {
            orderQueue.put((Order) arg);
        } catch (InterruptedException e) {
        }
    }
}
