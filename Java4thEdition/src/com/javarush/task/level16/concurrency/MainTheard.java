package com.javarush.task.level16.concurrency;

/**
 * Created by mvl on 05.04.2017.
 */
public class MainTheard {
    public static void main(String[] args) {
        LiftOff launch = new LiftOff();
        launch.run();
    }
}
