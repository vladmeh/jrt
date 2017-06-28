package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.statistic.event.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @autor mvl on 27.06.2017.
 */
public class StatisticManager {
    private static StatisticManager ourInstance = new StatisticManager();
    private StatisticStorage statisticStorage = new StatisticStorage();

    public static StatisticManager getInstance() {
        return ourInstance;
    }


    private StatisticManager() {
    }

    private class StatisticStorage{
        private Map<EventType, List<EventDataRow>> storage = new HashMap<>();

        public StatisticStorage() {
            for (EventType type: EventType.values()){
                storage.put(type, new ArrayList<EventDataRow>());
            }
        }
    }

    public void register(EventDataRow data){}
}
