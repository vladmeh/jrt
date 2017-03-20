package com.javarush.task.task14.task1408;

/**
 * Created by mvl on 20.03.2017.
 */
public class UkrainianHen extends Hen{
    @Override
    public int getCountOfEggsPerMonth() {
        return 10;
    }

    public String getDescription() {
        return String.format("%s Моя страна - %s. Я несу %d яиц в месяц.", super.getDescription(), Country.UKRAINE, getCountOfEggsPerMonth());
    }
}
