package com.javarush.task.task24.task2413;

/**
 * @autor mvl on 30.05.2017.
 */
public class Stand extends BaseObject {
    private double speed, direction;

    public Stand(double x, double y) {
        super(x, y, 3);
        this.direction = 0;
        this.speed = 1;
    }

    @Override
    public void draw(Canvas canvas) {

    }

    @Override
    public void move() {

    }

    public double getSpeed() {
        return speed;
    }

    public double getDirection() {
        return direction;
    }
}
