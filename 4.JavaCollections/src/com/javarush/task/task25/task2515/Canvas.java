package com.javarush.task.task25.task2515;

/**
 * @autor mvl on 25.07.2017.
 */
public class Canvas {
    private int width, height;
    private char[][] matrix;

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public char[][] getMatrix() {
        return matrix;
    }

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        this.matrix = new char[height][width];
    }
}
