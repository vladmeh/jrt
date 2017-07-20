package com.javarush.task.task22.task2213;

/**
 * @autor mvl on 20.07.2017.
 */
public class FigureFactory {
    public static Figure createRandomFigure(int x,int y){
        int[][] matrix = new int[y][x];

        return new Figure(x, y, matrix);
    }
}
