package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.Advertisement;
import com.javarush.task.task27.task2712.ad.StatisticAdvertisementManager;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.text.SimpleDateFormat;
import java.util.*;

public class DirectorTablet {

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

    public void printAdvertisementProfit(){
        double total = 0;
        for (Map.Entry<Date,Long> pair : StatisticManager.getInstance().getAdvertisementProfit().entrySet()) {
            double am = pair.getValue()/100.0;
            ConsoleHelper.writeMessage(String.format(Locale.ENGLISH, "%s - %.2f", simpleDateFormat.format(pair.getKey()), am));
            total+=am;
        }

        ConsoleHelper.writeMessage(String.format(Locale.ENGLISH, "Total - %.2f", total));
    }

    public void printCookWorkloading(){
        for(Map.Entry<Date, TreeMap<String,Integer>> pair : StatisticManager.getInstance().getCookWorkLoading().entrySet()) {
            ConsoleHelper.writeMessage(simpleDateFormat.format(pair.getKey()));
            for(Map.Entry<String,Integer> dailyCock: pair.getValue().entrySet()){
                ConsoleHelper.writeMessage(String.format("%s - %d min", dailyCock.getKey(),dailyCock.getValue()));
            }
        }
    }

    public void printActiveVideoSet(){
        List<Advertisement> videoSet = StatisticAdvertisementManager.getInstance().getActiveVideoSet();
        videoSet.sort((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()));
        for (Advertisement advertisement : videoSet) {
            ConsoleHelper.writeMessage(String.format("%s - %d",
                    advertisement.getName(),
                    advertisement.getHits()));
        }
    }

    public void printArchivedVideoSet(){
        List<Advertisement> videoSet = StatisticAdvertisementManager.getInstance().getArchivedVideoSet();
        videoSet.sort(((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName())));
        for (Advertisement advertisement: videoSet) {
            ConsoleHelper.writeMessage(advertisement.getName());
        }
    }
}
