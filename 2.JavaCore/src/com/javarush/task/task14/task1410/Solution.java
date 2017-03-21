package com.javarush.task.task14.task1410;

/* 
Дегустация вин
*/

public class Solution {
    public static void main(String[] args) {
        getDeliciousDrink().taste();
        System.out.println(getWine().getHolidayName());
        System.out.println(getBubblyWine().getHolidayName());
        System.out.println(getWine().getHolidayName());
    }

    public static Drink getDeliciousDrink() {
        Wine taste = new Wine();
        return taste;
    }

    public static Wine getWine() {
        return new Wine();
    }

    public static Wine getBubblyWine() {
        Wine bubblyWine = new BubblyWine();
        return bubblyWine;
    }
}
