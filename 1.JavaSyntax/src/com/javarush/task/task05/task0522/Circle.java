package com.javarush.task.task05.task0522;

/* 
Максимум конструкторов
*/

public class Circle {
    public double x;
    public double y;
    public double radius;

    public Circle(){
        this(5, 5, 1);
    }

    public Circle(double x, double y, double radius){
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public Circle(double x, double y) {
        this(x, y, 10);
    }

    public Circle(double radius){
        this(10, 10, radius);
    }

    public static void main(String[] args) {

    }
}