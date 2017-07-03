package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @autor mvl on 26.06.2017.
 */
public class Order {
    private final Tablet tablet;
    protected List<Dish> dishes;

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        initDishes();
    }

    /**
     * Get total cooking time int.
     * Продолжительность приготовления всего заказа.
     *
     * @return the int
     */
    public int getTotalCookingTime(){
        int totalTime = 0;
        for (Dish dish : dishes) {
            totalTime += dish.getDuration();
        }

        return totalTime;
    }

    @Override
    public String toString() {
        String result = "";

        if (!isEmpty()){
            return "Your order: " + dishes.toString() +" of "+  tablet.toString();
        }

        return result;
    }

    public boolean isEmpty() {
        return dishes.isEmpty();
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    protected void initDishes() throws IOException {
        this.dishes = ConsoleHelper.getAllDishesForOrder();
    }
}
