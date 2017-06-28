package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.util.*;

public class AdvertisementManager {
    private int timeSeconds;

    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() {
        List<Advertisement> videos = OptimalVideoList(powerLists(storage.list()));

        if (videos.isEmpty())
            throw new NoVideoAvailableException();

        videos.sort((o1, o2) -> {
            int result = Long.compare(o1.getAmountPerOneDisplaying(), o2.getAmountPerOneDisplaying());
            if (result != 0) return -result;
            else {
                long oneSecondCost1 = o1.getAmountPerOneDisplaying() * 1000 / o1.getDuration();
                long oneSecondCost2 = o2.getAmountPerOneDisplaying() * 1000 / o2.getDuration();
                return Long.compare(oneSecondCost1, oneSecondCost2);
            }
        });

        StatisticManager.getInstance().register(new VideoSelectedEventDataRow(videos, getTotalAmount(videos), getTotalTime(videos)));

        for (Advertisement advertisement : videos) {
            ConsoleHelper.writeMessage(advertisement.getName() + " is displaying... "
                    + advertisement.getAmountPerOneDisplaying() + ", "
                    + advertisement.getAmountPerOneDisplaying() * 1000 / advertisement.getDuration());

            advertisement.revalidate();
        }
    }

    private List<Advertisement> OptimalVideoList(List<List<Advertisement>> list) {
        List<Advertisement> optimal;
        Iterator A = list.iterator();

        while (A.hasNext()) {  // Перебор наборов видео
            List<Advertisement> checkList = (ArrayList<Advertisement>) A.next();
            int timeOfVideoSet = 0;
            boolean removeSet = false;
            for (Advertisement a : checkList) {      // Перебор = видео в наборе
                timeOfVideoSet += a.getDuration();
                if (a.getHits() <= 0) {
                    removeSet = true;
                }
            }
            if (timeOfVideoSet > timeSeconds) {
                removeSet = true;
            }
            if (removeSet) {
                A.remove();
            }
        }
        Comparator comparator = (Comparator<List<Advertisement>>) (o1, o2) -> {
            long profit1 = 0, profit2 = 0;
            int durationOfVideoSet1 = 0, durationOfVideoSet2 = 0;
            for (Advertisement a : o1) {
                profit1 += a.getAmountPerOneDisplaying();
                durationOfVideoSet1 += a.getDuration();
            }
            for (Advertisement a : o2) {
                profit2 += a.getAmountPerOneDisplaying();
                durationOfVideoSet2 += a.getDuration();
            }
            if (profit1 != profit2)
                return Long.compare(profit2, profit1);   // первичная по прибыли от показа (по убыванию)
            if (durationOfVideoSet1 != durationOfVideoSet2)
                return Integer.compare(durationOfVideoSet2, durationOfVideoSet1);  // вторичная по длительности (по убыванию)
            else return Integer.compare(o1.size(), o2.size());  // по размеру списка (по возрастанию)
        };
        list.sort(comparator);
        optimal = list.get(0);    // выбираем первый элемент(найболее подходящий)
        return optimal;
    }

    private <Advertisement> List<List<Advertisement>> powerLists(List<Advertisement> originalSet) {
        List<List<Advertisement>> lists = new ArrayList<>();
        if (originalSet.isEmpty()) {
            lists.add(new ArrayList<Advertisement>());
            return lists;
        }

        List<Advertisement> list = new ArrayList<>(originalSet);
        Advertisement head = list.get(0);
        List<Advertisement> rest = new ArrayList<>(list.subList(1, list.size()));
        for (List<Advertisement> aList : powerLists(rest)) {
            List<Advertisement> newList = new ArrayList<>();
            newList.add(head);
            newList.addAll(aList);
            lists.add(newList);
            lists.add(aList);
        }
        return lists;
    }

    private long getTotalAmount(List<Advertisement> ad) {
        long totalAmount = 0;
        if (ad == null) return totalAmount;
        for (Advertisement a : ad) {
            totalAmount += a.getAmountPerOneDisplaying();
        }
        return totalAmount;
    }

    private int getTotalTime(List<Advertisement> ad) {
        int totalTime = 0;
        if (ad == null) return totalTime;
        for (Advertisement a : ad) {
            totalTime += a.getDuration();
        }
        return totalTime;
    }
}
