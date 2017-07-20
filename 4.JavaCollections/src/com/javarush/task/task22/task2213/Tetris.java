package com.javarush.task.task22.task2213;

/**
 * @autor mvl on 20.07.2017.
 */
public class Tetris {
    private Field field;
    private Figure figure;

    public static Tetris game;

    public static void main(String[] args) {
        game = new Tetris();
        game.run();
    }

    public void run(){}

    public void step(){}

    public Field getField() {
        return field;
    }

    public Figure getFigure() {
        return figure;
    }
}
