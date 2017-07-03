package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.AdvertisementManager;
import com.javarush.task.task27.task2712.ad.NoVideoAvailableException;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.TestOrder;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.NoAvailableVideoEventDataRow;

import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The type Tablet.
 *
 * @autor mvl on 26.06.2017.
 */
public class Tablet {
    private final int number;
    private static Logger logger = Logger.getLogger(Tablet.class.getName());
    private LinkedBlockingQueue<Order> queue;

    /**
     * Instantiates a new Tablet.
     *
     * @param number номер планшета, что бы можно было установить откуда поступил заказ
     */
    public Tablet(int number) {
        this.number = number;
    }

    /**
     * Create order order.
     * Создает заказ из тех блюд, которые выбирает пользователь
     *
     * @return the order
     */
    public Order createOrder() {

        Order order = null;
        try {
            order = new Order(this);
            insideOrder(order);

        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
        }

        return order;
    }

    public void createTestOrder() {
        try {
            final Order order = new TestOrder(this);
            insideOrder(order);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
        }
    }

    private void insideOrder(Order order) {
        if (order.isEmpty()) return;
        ConsoleHelper.writeMessage(order.toString());
        try {
            queue.put(order);
        } catch (InterruptedException e) {
            return;
        }
        try {
            new AdvertisementManager(order.getTotalCookingTime() * 60).processVideos();
        } catch (NoVideoAvailableException e) {
            StatisticManager.getInstance().register(new NoAvailableVideoEventDataRow(order.getTotalCookingTime() * 60));
            logger.log(Level.INFO, "No video is available for the order " + order);
        }
    }

    @Override
    public String toString() {
        return "Tablet{number=" + number + "}";
    }

    public int getNumber() {
        return number;
    }

    public void setQueue(LinkedBlockingQueue<Order> queue) {
        this.queue = queue;
    }
}
