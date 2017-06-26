package com.javarush.task.task27.task2712.ad;

/**
 * @autor mvl on 26.06.2017.
 */
public class Advertisement {
    private Object content;
    private String name;
    private long initialAmount;
    private int hits, duration;

    private long amountPerOneDisplaying;

    public Advertisement(Object content, String name, long initialAmount, int hits, int duration) {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;

        this.amountPerOneDisplaying = initialAmount/hits;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public long getAmountPerOneDisplaying() {
        return amountPerOneDisplaying;
    }
}
