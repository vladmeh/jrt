package com.javarush.task.task27.task2712.statistic.event;

import com.javarush.task.task27.task2712.ad.Advertisement;

import java.util.Date;
import java.util.List;

/**
 * The type Video selected event data row.
 *
 * @autor mvl on 27.06.2017.
 */
public class VideoSelectedEventDataRow implements EventDataRow{
    List<Advertisement> optimalVideoSet;
    long amount;
    int totalDuration;

    Date currentDate;

    /**
     * Instantiates a new Video selected event data row.
     *
     * @param optimalVideoSet список видео-роликов, отобранных для показа
     * @param amount          сумма денег в копейках
     * @param totalDuration   бщая продолжительность показа отобранных рекламных роликов
     */
    public VideoSelectedEventDataRow(List<Advertisement> optimalVideoSet, long amount, int totalDuration) {
        this.optimalVideoSet = optimalVideoSet;
        this.amount = amount;
        this.totalDuration = totalDuration;

        this.currentDate = new Date();
    }
}
