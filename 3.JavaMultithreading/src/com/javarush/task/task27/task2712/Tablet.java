package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.AdvertisementManager;
import com.javarush.task.task27.task2712.ad.NoVideoAvailableException;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.TestOrder;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.NoAvailableVideoEventDataRow;

import java.io.IOException;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The type Tablet.
 *
 * @autor mvl on 26.06.2017.
 */
public class Tablet extends Observable{
    private final int number;
    private static Logger logger = Logger.getLogger(Tablet.class.getName());

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
    public Order createOrder(){

        Order order = null;
        try {
            order = new Order(this);
            insideOrder(order);

        }
        catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
        }

        return order;
    }

    public void createTestOrder(){
        try {
            Order order = new TestOrder(this);
            insideOrder(order);
        }
        catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
        }
    }

    private void insideOrder(Order order) {
        try {
            ConsoleHelper.writeMessage(order.toString());
            if (!order.isEmpty()) {
                AdvertisementManager adm = new AdvertisementManager(order.getTotalCookingTime() * 60);

                setChanged();
                notifyObservers(order);
                adm.processVideos();
            }
        } catch (NoVideoAvailableException e) {
            StatisticManager.getInstance().register(new NoAvailableVideoEventDataRow(order.getTotalCookingTime()*60));
            logger.log(Level.INFO,"No video is available for the order " + order);
        }
    }

    @Override
    public String toString() {
        return "Tablet{number=" + number + "}";
    }

    public int getNumber() {
        return number;
    }
}
