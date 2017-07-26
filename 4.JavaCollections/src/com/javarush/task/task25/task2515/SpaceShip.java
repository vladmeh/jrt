package com.javarush.task.task25.task2515;

/**
 * @autor mvl on 25.07.2017.
 */
public class SpaceShip extends BaseObject {
    private double dx;

    public SpaceShip(double x, double y) {
        super(x, y, 3);
    }

    public void moveLeft() {
        this.dx = -1;
    }

    public void moveRight(){
        this.dx = 1;
    }
}
