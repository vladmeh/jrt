package com.javarush.task.task27.task2712.statistic.event;

import java.util.Date;

/**
 * @autor mvl on 27.06.2017.
 */
public interface EventDataRow {
    EventType getType();
    Date getDate();
    int getTime();
}
