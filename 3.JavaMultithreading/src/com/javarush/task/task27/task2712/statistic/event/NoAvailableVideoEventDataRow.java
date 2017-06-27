package com.javarush.task.task27.task2712.statistic.event;

import java.util.Date;

/**
 * The type No available video event data row.
 *
 * @autor mvl on 27.06.2017.
 */
public class NoAvailableVideoEventDataRow implements EventDataRow{
    /**
     * время приготовления заказа в секундах.
     */
    int totalDuration;

    Date currentDate;

    /**
     * Instantiates a new No available video event data row.
     *
     * @param totalDuration время приготовления заказа в секундах
     */
    public NoAvailableVideoEventDataRow(int totalDuration) {
        this.totalDuration = totalDuration;
        this.currentDate = new Date();
    }
}
