package com.javarush.task.task27.task2712.ad;

/**
 * The type Advertisement.
 *
 * @autor mvl on 26.06.2017.
 */
public class Advertisement {
    private Object content;
    private String name;
    private long initialAmount;
    private int hits, duration;

    private long amountPerOneDisplaying;

    /**
     * Instantiates a new Advertisement.
     *
     * @param content       видео
     * @param name          имя/название
     * @param initialAmount начальная сумма, стоимость рекламы в копейках. Используем long, чтобы избежать проблем с округлением
     * @param hits          количество оплаченных показов
     * @param duration      продолжительность одного показа в секундах
     */
    public Advertisement(Object content, String name, long initialAmount, int hits, int duration) {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;

        this.amountPerOneDisplaying = initialAmount/hits;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets duration.
     *
     * @return the duration
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Gets amount per one displaying.
     * стоимость одного показа рекламного объявления в копейках
     *
     * @return the amount per one displaying
     */
    public long getAmountPerOneDisplaying() {
        return amountPerOneDisplaying;
    }

    public double getAmountPerSecond() {
        return (double)amountPerOneDisplaying / duration;
    }

    /**
     * Revalidate.
     */
    public void revalidate(){
        if (hits <= 0) throw new UnsupportedOperationException();
        hits--;
        if (hits == 1) amountPerOneDisplaying += initialAmount % amountPerOneDisplaying;
    }

    public int getHits() {
        return hits;
    }
}
