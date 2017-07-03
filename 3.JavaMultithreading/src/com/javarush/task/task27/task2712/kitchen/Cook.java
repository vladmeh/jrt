package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;

/**
 * @autor mvl on 26.06.2017.
 */
public class Cook extends Observable{
    private final String name;
    private boolean busy;

    public Cook(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }


    public void startCookingOrder(Order order) throws InterruptedException {
        busy = true;
        ConsoleHelper.writeMessage(String.format("Start cooking - %s, cooking time %dmin", order, order.getTotalCookingTime()));

        Thread.sleep(order.getTotalCookingTime() * 10);

        StatisticManager.getInstance().register(
                new CookedOrderEventDataRow(
                        order.getTablet().toString(),
                        this.toString(),
                        order.getTotalCookingTime() * 60,
                        order.getDishes()
                )
        );

        setChanged();
        notifyObservers(order);
        busy = false;
    }

    public boolean isBusy() {
        return busy;
    }
}
