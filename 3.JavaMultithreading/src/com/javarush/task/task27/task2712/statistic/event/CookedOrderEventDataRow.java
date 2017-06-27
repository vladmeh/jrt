package com.javarush.task.task27.task2712.statistic.event;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.util.Date;
import java.util.List;

/**
 * The type Cooked order event data row.
 *
 * @autor mvl on 27.06.2017.
 */
public class CookedOrderEventDataRow implements EventDataRow{

    String tabletName, cookName;
    int cookingTimeSeconds;
    List<Dish> cookingDishs;

    Date currentDate;

    /**
     * @param tabletName          имя планшета
     * @param cookName           имя повара
     * @param cookingTimeSeconds время приготовления заказа в секундах
     * @param cookingDishs       список блюд для приготовления
     */
    public CookedOrderEventDataRow(String tabletName, String cookName, int cookingTimeSeconds, List<Dish> cookingDishs) {
        this.tabletName = tabletName;
        this.cookName = cookName;
        this.cookingTimeSeconds = cookingTimeSeconds;
        this.cookingDishs = cookingDishs;

        this.currentDate = new Date();
    }
}
