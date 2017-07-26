package com.javarush.task.task25.task2515;

/**
 * @autor mvl on 25.07.2017.
 */
public class Bomb extends BaseObject{
    public Bomb(double x, double y) {
        super(x, y, 1);
    }

    @Override
    public void move() {
        setY(getY()+1);
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.setPoint(getX(), getY(), 'B');
    }


}
