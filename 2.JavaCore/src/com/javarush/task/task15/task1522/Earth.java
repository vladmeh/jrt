package com.javarush.task.task15.task1522;

/**
 * Created by vlad on 25.03.2017.
 */

public class Earth implements Planet{
    private static Earth instance;

    private Earth() {
    }

    public static Earth getInstance() {
        if (instance == null)
            instance = new Earth();

        return instance;
    }
}
