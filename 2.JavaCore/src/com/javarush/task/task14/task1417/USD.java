package com.javarush.task.task14.task1417;

/**
 * Created by mvl on 21.03.2017.
 */
public class USD extends Money {
    @Override
    public String getCurrencyName() {
        return this.getClass().getSimpleName();
    }

    public USD(double amount) {
        super(amount);
    }
}
