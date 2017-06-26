package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @autor mvl on 26.06.2017.
 */
public class ConsoleHelper {
    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException {
        String text = bis.readLine();
        return text;
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        List<Dish> listDish = new ArrayList<>();
        writeMessage("[Make your order]:\n" + Dish.allDishesToString());

        while (true)
        {
            String str = readString();
            if (str.equalsIgnoreCase("exit"))
                break;
            else
            {
                try
                {
                    listDish.add(Dish.valueOf(str));
                }
                catch (IllegalArgumentException e)
                {
                    writeMessage(str + " is not detected");
                }
            }
        }
        return listDish;
    }
}
