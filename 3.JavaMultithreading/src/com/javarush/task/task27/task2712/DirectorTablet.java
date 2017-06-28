package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @autor mvl on 28.06.2017.
 */
public class DirectorTablet {

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

    public void printAdvertisementProfit(){
        TreeMap<Date, Long> advertisementRevenueAgregatedByDay = StatisticManager.getInstance().getAdvertisementRevenueAgregatedByDay();
        if (advertisementRevenueAgregatedByDay.isEmpty()) return;
        NavigableSet<Date> datesRow = advertisementRevenueAgregatedByDay.descendingKeySet();
        Long totalAmmout = Long.valueOf(0);
        for (Date date : datesRow) {
            Long dayAmount = advertisementRevenueAgregatedByDay.get(date);
            totalAmmout += dayAmount;
            ConsoleHelper.writeMessage(String.format(Locale.ENGLISH, "%s - %.2f",
                    new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(date),
                    0.01d * dayAmount)
            );
        }
        ConsoleHelper.writeMessage(String.format(Locale.ENGLISH, "Total - %.2f", 0.01d * totalAmmout));
    }

    public void printCookWorkloading(){
        TreeMap<Date, HashMap<String, Integer>> cookWorkloadingAgregatedByDay = StatisticManager.getInstance().getCookWorkloadingAgregatedByDay();
        if (cookWorkloadingAgregatedByDay.isEmpty()) return;
        NavigableSet<Date> datesRow = cookWorkloadingAgregatedByDay.descendingKeySet();
        for (Date date: datesRow) {
            ConsoleHelper.writeMessage(simpleDateFormat.format(date));

            List<Map.Entry<String, Integer>> cooksNameWorkDuration = new ArrayList(cookWorkloadingAgregatedByDay.get(date).entrySet());

            Collections.sort(cooksNameWorkDuration, (a, b) -> b.getValue() - a.getValue());
            for (Map.Entry<String, Integer> cookNameWorkDuration: cooksNameWorkDuration) {
                ConsoleHelper.writeMessage(String.format("%s - %d min",
                        cookNameWorkDuration.getKey(),
                        (int)Math.ceil(cookNameWorkDuration.getValue() / 60.0))
                );
            }
        }
    }

    public void printActiveVideoSet(){}

    public void printArchivedVideoSet(){}
}
