package com.javarush.task.task27.task2712.kitchen;

import java.util.Arrays;

/**
 * @autor mvl on 26.06.2017.
 */
public enum Dish {
    Fish,
    Steak,
    Soup,
    Juice,
    Water;

    public static String allDishesToString(){
        return Arrays.toString(values()).substring(1, Arrays.toString(values()).length() - 1);
    }
}
