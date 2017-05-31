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
        double dx = speed * direction;
        x += dx;
    }

    public void moveLeft(){
        this.direction = -1;
    }

    public void moveRight(){
        this.direction = 1;
    }

    public double getSpeed() {
        return speed;
    }

    public double getDirection() {
        return direction;
    }
}
