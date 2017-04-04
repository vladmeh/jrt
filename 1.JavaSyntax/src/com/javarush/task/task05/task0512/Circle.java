package com.javarush.task.task05.task0512;

/* 
Создать класс Circle

Создать класс (Circle) круг, с тремя инициализаторами:
— centerX, centerY, radius
— centerX, centerY, radius, width
— centerX, centerY, radius, width, color


Требования:
1. Программа не должна считывать данные с клавиатуры.
2. У класса Circle должны быть переменные centerX, centerY, radius, width и color с типом int.
3. У класса должен быть метод initialize, принимающий в качестве параметров centerX, centerY, radius и инициализирующий соответствующие переменные класса.
4. У класса должен быть метод initialize, принимающий в качестве параметров centerX, centerY, radius, width и инициализирующий соответствующие переменные класса.
5. У класса должен быть метод initialize, принимающий в качестве параметров centerX, centerY, radius, width, color и инициализирующий соответствующие переменные класса.
*/

public class Circle {
    private int centerX, centerY, radius, width, color;

    public void initialize(int x, int y, int r){
        this.centerX = x;
        this.centerY = y;
        this.radius = r;
    }

    public void initialize(int x, int y, int r, int w){
        this.centerX = x;
        this.centerY = y;
        this.radius = r;
        this.width = w;
    }

    public void initialize(int x, int y, int r, int w, int c){
        this.centerX = x;
        this.centerY = y;
        this.radius = r;
        this.width = w;
        this.color = c;
    }

    public static void main(String[] args) {

    }
}
