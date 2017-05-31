package com.javarush.task.task24.task2413;

/**
 * Created by mvl on 30.05.2017.
 */
public class Ball extends BaseObject{
    private double speed, direction, dx, dy;
    private boolean isFrozen;

    public Ball(double x, double y, double speed, double direction) {
        super(x, y, 1);
        this.speed = speed;
        this.direction = direction;
        this.isFrozen = true;
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.setPoint(x,y,'O');
    }

    @Override
    public void move() {
        if (isFrozen) return;

        x += dx;
        y += dy;
    }

    public void start(){
        this.isFrozen = false;
    }

    public double getSpeed() {
        return speed;
    }

    public double getDirection() {
        return direction;
    }

    public double getDx() {
        return dx;
    }

    public double getDy() {
        return dy;
    }
}
