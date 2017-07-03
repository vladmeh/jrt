package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @autor mvl on 03.07.2017.
 */
public class OrderManager implements Observer {
    private LinkedBlockingQueue<Order> orderQueue = new LinkedBlockingQueue<>();

    public OrderManager() {
        Thread thread = new Thread(() -> {
            while (true){
                try {
                    //из пояснения в следующей задаче 22
                    for (Cook cook: StatisticManager.getInstance().getCooks()){
                        //находим повара, т.е. проверяем совбоден ли повар
                        if (!cook.isBusy()){
                            //потом находим заказ, т.е. проверяем очередь пустая или нет
                            if (!orderQueue.isEmpty()){
                                //отдаем заказ повару
                                cook.startCookingOrder(orderQueue.take());
                            }
                        }
                        //ждем окончания приготовления заказа
                        Thread.sleep(10);
                    }
                } catch (InterruptedException ignored) {
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
    }

    @Override
    public void update(Observable o, Object arg) {
        try {
            orderQueue.put((Order) arg);
        } catch (InterruptedException ignored) {
        }
    }
}
