package com.javarush.task.task22.task2213;

/**
 * @autor mvl on 20.07.2017.
 */
public class Field {
    private int width, height;
    private int[][] matrix;

    public Field(int width, int height) {
        this.width = width;
        this.height = height;
        this.matrix = new int[height][width];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int[][] getMatrix() {
        return matrix;
    }
}
