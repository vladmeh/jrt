package com.javarush.task.task06.task0605;


import java.io.*;

/* 
Контролируем массу тела
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
        double weight = Double.parseDouble(bis.readLine());
        double height = Double.parseDouble(bis.readLine());

        Body.massIndex(weight, height);
    }

    public static class Body {
        public static void massIndex(double weight, double height) {
            double i = weight / (height * height);

            if (i < 18.5) System.out.println("Недовес: меньше чем 18.5");
            if (i >= 18.5 && i <= 24.9) System.out.println("Нормальный: между 18.5 и 24.9");
            if (i >= 25 && i <= 29.9) System.out.println("Избыточный вес: между 25 и 29.9");
            if (i >= 30) System.out.println("Ожирение: 30 или больше");
        }
    }
}
