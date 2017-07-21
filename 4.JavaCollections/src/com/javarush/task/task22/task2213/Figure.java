package com.javarush.task.task22.task2213;

/**
 * @autor mvl on 20.07.2017.
 */
public class Figure {
    private int x, y;
    private int[][] matrix;

    public Figure(int x, int y, int[][] matrix) {
        this.x = x;
        this.y = y;
        this.matrix = matrix;
    }

    public void left(){
        x--;
        if (!isCurrentPositionAvailable())
            x++;
    }

    public void right(){
        x++;
        if (!isCurrentPositionAvailable())
            x--;
    }

    public void down(){
        y++;
    }

    public void up(){
        y--;
    }

    public void rotate(){}

    public void downMaximum(){}

    public boolean isCurrentPositionAvailable(){
        return true;
    }

    public void landed(){}

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int[][] getMatrix() {
        return matrix;
    }
}
