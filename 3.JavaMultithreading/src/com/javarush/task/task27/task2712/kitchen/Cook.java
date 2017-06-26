package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;

import java.util.Observable;
import java.util.Observer;

/**
 * @autor mvl on 26.06.2017.
 */
public class Cook extends Observable implements Observer{
    private final String name;

    public Cook(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof Order){
            Order order = (Order) arg;
            ConsoleHelper.writeMessage(String.format("Start cooking - %s, cooking time %dmin", order, order.getTotalCookingTime()));

            setChanged();
            notifyObservers(order);
        }
    }
}
