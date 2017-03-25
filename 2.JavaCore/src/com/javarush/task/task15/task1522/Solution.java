package com.javarush.task.task15.task1522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Закрепляем Singleton pattern
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static Planet thePlanet;

    //Метод readKeyFromConsoleAndInitPlanet должен быть вызван в статическом блоке класса Solution.
    static
    {
        readKeyFromConsoleAndInitPlanet();
    }

    public static void readKeyFromConsoleAndInitPlanet() {
        // Метод readKeyFromConsoleAndInitPlanet должен корректно обновлять значение переменной thePlanet
        // в соответствии с условием задачи.
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String param = reader.readLine();
            if (param.equals(Planet.EARTH))
                thePlanet = Earth.getInstance();

            else if (param.equals(Planet.MOON))
                thePlanet = Moon.getInstance();

            else if (param.equals(Planet.SUN))
                thePlanet = Sun.getInstance();

            else
                thePlanet = null;

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
