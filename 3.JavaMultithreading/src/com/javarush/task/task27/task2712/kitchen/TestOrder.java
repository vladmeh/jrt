package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @autor mvl on 03.07.2017.
 */
public class TestOrder extends Order {
    public TestOrder(Tablet tablet) throws IOException {
        super(tablet);
    }

    @Override
    protected void initDishes() throws IOException {
        ConsoleHelper.writeMessage(Dish.allDishesToString());
        dishes = new ArrayList<>();
        dishes.addAll(Arrays.asList(Dish.values()));
        int randDishCount = (int)(ThreadLocalRandom.current().nextDouble(1) * Dish.values().length) + 1;
        int countOfDishToDelete = dishes.size() - randDishCount;
        for (int i = 0; i < countOfDishToDelete; i++) {
            dishes.remove((int)(ThreadLocalRandom.current().nextDouble(1) * dishes.size()));
        }
    }
}
