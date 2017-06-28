package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class StatisticManager {
    private static StatisticManager ourInstance = new StatisticManager();
    private StatisticStorage statisticStorage = new StatisticStorage();
    private Set<Cook> cooks = new HashSet<>();
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

    public static StatisticManager getInstance() {
        return ourInstance;
    }


    private StatisticManager() {
    }

    private class StatisticStorage{
        private Map<EventType, List<EventDataRow>> storage;

        private StatisticStorage() {
            storage = new HashMap<>();
            for (EventType eventType : EventType.values()) {
                storage.put(eventType, new ArrayList<EventDataRow>());
            }
        }

        private void put(EventDataRow data){
            storage.get(data.getType()).add(data);
        }

        private List<EventDataRow> get(EventType eventType){
            return storage.get(eventType);
        }
    }

    public void register(EventDataRow data){
        statisticStorage.put(data);
    }

    public void register(Cook cook){
        cooks.add(cook);
    }

    public TreeMap<Date, Long> getAdvertisementProfit() {
        TreeMap<Date,Long> map = new TreeMap<>(Collections.reverseOrder());
        List<EventDataRow> videos = statisticStorage.get(EventType.SELECTED_VIDEOS);

        for(EventDataRow eventDataRow: videos) {
            Date date = null;
            try {
                date = simpleDateFormat.parse(simpleDateFormat.format(eventDataRow.getDate()));
            } catch (ParseException e){
                e.printStackTrace();
            }
            if (map.containsKey(date)) {
                map.put(date,map.get(date)+((VideoSelectedEventDataRow)eventDataRow).getAmount());
            } else
                map.put(date,((VideoSelectedEventDataRow)eventDataRow).getAmount());
        }

        return map;
    }

    public TreeMap<Date, TreeMap<String, Integer>> getCookWorkLoading() {
        TreeMap<Date, TreeMap<String,Integer>> map= new TreeMap<>(Collections.reverseOrder());
        List<EventDataRow> list = statisticStorage.get(EventType.COOKED_ORDER);

        for(EventDataRow eventDataRow: list) {
            Date date = null;
            try {
                date = simpleDateFormat.parse(simpleDateFormat.format(eventDataRow.getDate())); // дата без времени
            } catch (ParseException e){
                e.printStackTrace();
            }
            String cookName = ((CookedOrderEventDataRow) eventDataRow).getCookName();  // имя повара
            int time = (int)Math.ceil(eventDataRow.getTime()/60.0);  // время в минутах
            if(map.containsKey(date)) {
                if(map.get(date).containsKey(cookName))
                    map.get(date).put(cookName, map.get(date).get(cookName) + time);
                else map.get(date).put(cookName, time);
            }
            else {
                TreeMap<String, Integer> tempMap = new TreeMap<>();
                tempMap.put(cookName,time);
                map.put(date, tempMap);
            }
        }
        return map;
    }
}
