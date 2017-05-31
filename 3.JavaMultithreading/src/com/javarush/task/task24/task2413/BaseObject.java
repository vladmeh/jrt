package com.javarush.task.task24.task2413;

/**
 * @autor mvl on 30.05.2017.
 */
public abstract class BaseObject {
    protected double x, y, radius;

    public BaseObject(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public abstract void draw(Canvas canvas);

    public abstract void move();

    public boolean isIntersec(BaseObject o){
        //расстояние между двумя точками на плоскости
        double dx = x - o.x;
        double dy = y - o.y;
        //теорема Пифагора
        double destination = Math.sqrt(dx * dx + dy * dy);

        double destination2 = Math.max(radius, o.radius);
        return destination <= destination2;
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
}
