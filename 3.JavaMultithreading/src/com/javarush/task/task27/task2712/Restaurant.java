package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Waiter;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.util.ArrayList;
import java.util.List;

/**
 * @autor mvl on 26.06.2017.
 */
public class Restaurant {
    private static final int ORDER_CREATING_INTERVAL = 100;

    public static void main(String[] args) {


        Cook cookAmigo = new Cook("Amigo");
        Cook cookDiego = new Cook("Diego");
        StatisticManager.getInstance().register(cookAmigo);
        StatisticManager.getInstance().register(cookDiego);

        Waiter waiter = new Waiter();
        cookAmigo.addObserver(waiter);
        cookDiego.addObserver(waiter);

        OrderManager orderManager = new OrderManager();
        List<Tablet> tablets = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Tablet tablet = new Tablet(i + 1);
            tablets.add(tablet);
            tablets.get(i).addObserver(orderManager);
        }

        Thread randomOrderGeneratorTaskThread = new Thread(new RandomOrderGeneratorTask(tablets, ORDER_CREATING_INTERVAL));
        randomOrderGeneratorTaskThread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        randomOrderGeneratorTaskThread.interrupt();

        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();
    }
}
