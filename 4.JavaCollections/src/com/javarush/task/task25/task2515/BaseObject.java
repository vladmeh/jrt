package com.javarush.task.task25.task2515;

/**
 * @autor mvl on 25.07.2017.
 */
public abstract class BaseObject {
    private double x, y, radius;
    private boolean isAlive;

    public boolean isAlive() {
        return isAlive;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public BaseObject(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.isAlive = true;
    }

    public void draw(){}

    public void move(){}

    public void die(){
        this.isAlive = false;
    }

    public boolean isIntersect(BaseObject o){
        //расстояние между двумя точками на плоскости
        double dx = x - o.x;
        double dy = y - o.y;

        return Math.sqrt(dx * dx + dy * dy) < Math.max(radius, o.radius);
    }
}
