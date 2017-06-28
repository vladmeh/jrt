package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;

import java.util.Observable;
import java.util.Observer;

/**
 * @autor mvl on 26.06.2017.
 */
public class Waiter extends Observable implements Observer {
    /**
     * @param o  объект, который отправил нам значение - Cook
     * @param arg само значение - Order
     */
    @Override
    public void update(Observable o, Object arg) {
        ConsoleHelper.writeMessage(String.format("%s was cooked by %s", arg, o));
    }
}
