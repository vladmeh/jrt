package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Waiter;

/**
 * @autor mvl on 26.06.2017.
 */
public class Restaurant {
    public static void main(String[] args) {

        Waiter waiter = new Waiter();
        Cook cook = new Cook("Amigo");
        cook.addObserver(waiter);

        Tablet tablet = new Tablet(5);
        tablet.addObserver(cook);
        tablet.createOrder();
    }
}
