package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Order;

import java.io.IOException;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @autor mvl on 26.06.2017.
 */
public class Tablet extends Observable{
    final int number;
    private static Logger logger = Logger.getLogger(Tablet.class.getName());

    public Tablet(int number) {
        this.number = number;
    }

    public Order createOrder(){

        Order order = null;

        try {
            order = new Order(this);
            ConsoleHelper.writeMessage(order.toString());

            setChanged();
            notifyObservers(order);

        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
        }

        return order;
    }

    @Override
    public String toString() {
        return "Tablet{number=" + number + "}";
    }
}
