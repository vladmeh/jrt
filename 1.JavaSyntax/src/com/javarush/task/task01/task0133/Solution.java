package com.javarush.task.task01.task0133;

/* 
Не думать о секундах…
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getCountSecondsPassedInCurrentHour(12345));
    }

    public static int getCountSecondsPassedInCurrentHour(int seconds) {
<<<<<<< HEAD
        return seconds % 3600;
=======
        int secondsCurrentHour = seconds % 3600;

        return secondsCurrentHour;
>>>>>>> 6d0a2e93acded99e924263fe8dc5ddb5e35fb270
    }
}