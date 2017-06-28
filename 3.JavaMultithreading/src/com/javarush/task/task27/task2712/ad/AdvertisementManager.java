package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class AdvertisementManager {
    private int timeSeconds;

    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() throws NoVideoAvailableException{
        List<Advertisement> candidates = new ArrayList<>();
        //Include only compatible by duration video
        for (Advertisement ad: storage.list()) {
            if (ad.getDuration() <= timeSeconds && ad.getHits() > 0)
                candidates.add(ad);
        }

        //If no one compatible
        if (candidates.isEmpty()) {
            throw new NoVideoAvailableException();
        }

        //Select optimal video set by exhaustive search
        OptimalVideoSet optimalVideoSet = new OptimalVideoSet(candidates, timeSeconds);
        List<Advertisement> optimalVideoList = optimalVideoSet.getOptimalVideoSet();
        //Sort video playlist
        Collections.sort(optimalVideoList, (o1, o2) -> (int) (o1.getAmountPerOneDisplaying() == o2.getAmountPerOneDisplaying()
                ? (o1.getAmountPerSecond() - o2.getAmountPerSecond()) * 1000000
                : o2.getAmountPerOneDisplaying() - o1.getAmountPerOneDisplaying()));

        //Register event before showing videos
        StatisticManager.getInstance().register(
                new VideoSelectedEventDataRow(
                        optimalVideoList,
                        optimalVideoSet.getOptimalVideoSetAmount(),
                        optimalVideoSet.getOptimalVideoSetDuration()
                )
        );

        //Show videos & update ads' data
        for (int i = 0; i < optimalVideoList.size(); i++) {
            Advertisement advertisement = optimalVideoList.get(i);
            ConsoleHelper.writeMessage(String.format("%s is displaying... %d, %d",
                    advertisement.getName(),
                    advertisement.getAmountPerOneDisplaying(),
                    (int)(advertisement.getAmountPerOneDisplaying() * 1000 / advertisement.getDuration())
            ));
            advertisement.revalidate();

        }
    }

    private class OptimalVideoSet  {
        private int toShowTimeSeconds;
        private CopyOnWriteArrayList<Advertisement> candidates_ = new CopyOnWriteArrayList<>();

        private int optimalVideoSetAmount = 0;
        private int optimalVideoSetTime = 0;
        private CopyOnWriteArrayList<Advertisement> optimalVideoSet;


        public OptimalVideoSet(List<Advertisement> candidates, int toShowTimeSeconds) {
            this.toShowTimeSeconds = toShowTimeSeconds;
            this.candidates_.addAll(candidates);
        }

        public List<Advertisement> getOptimalVideoSet() {
            sortOut(candidates_);
            List<Advertisement> result = new ArrayList<>();
            result.addAll(optimalVideoSet);
            return result;
        }

        //exhaustive search
        private void sortOut(CopyOnWriteArrayList<Advertisement> candidates) {
            CopyOnWriteArrayList<Advertisement> currentList = candidates;
            //Calculate current video set parameters
            int amountOfAd = 0;
            int sumOfAdTime = 0;
            for (Advertisement ad : currentList) {
                amountOfAd += ad.getAmountPerOneDisplaying();
                sumOfAdTime += ad.getDuration();
            }
            //If video set is too long eliminate each video
            // & invoke optimal set finding in recursion sequentially
            if (sumOfAdTime > toShowTimeSeconds)
                for (int i = currentList.size() - 1; i >= 0; i--) {
                    candidates = (CopyOnWriteArrayList<Advertisement>) currentList.clone();
                    candidates.remove(i);
                    sortOut(candidates);
                }
            else {
                //Replace optimal result if current set is better
                if (amountOfAd > optimalVideoSetAmount) {
                    optimalVideoSet = currentList;
                } else if (amountOfAd == optimalVideoSetAmount)
                    if (sumOfAdTime > optimalVideoSetTime)
                        optimalVideoSet = currentList;
                    else if (sumOfAdTime == optimalVideoSetTime)
                        if (currentList.size() < optimalVideoSet.size())
                            optimalVideoSet = currentList;
                if (optimalVideoSet == currentList) {
                    optimalVideoSetAmount = amountOfAd;
                    optimalVideoSetTime = sumOfAdTime;
                }
            }
        }

        public int getOptimalVideoSetDuration() {
            return optimalVideoSetTime;
        }

        public int getOptimalVideoSetAmount() {
            return optimalVideoSetAmount;
        }
    }
}
