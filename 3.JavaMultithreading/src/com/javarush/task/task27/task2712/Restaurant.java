package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;

/**
 * @autor mvl on 26.06.2017.
 */
public class Restaurant {
    public static void main(String[] args) {
        Tablet tablet = new Tablet(5);
        Cook cook = new Cook("Amigo");

        tablet.addObserver(cook);
        tablet.createOrder();
    }
}
