package com.javarush.task.task35.task3513;

/**
 * @autor mvl on 10.07.2017.
 */
public class MoveEfficiency {
    private int numberOfEmptyTiles, score;
    private Move move;

    public MoveEfficiency(int numberOfEmptyTiles, int score, Move move) {
        this.numberOfEmptyTiles = numberOfEmptyTiles;
        this.score = score;
        this.move = move;
    }

    public Move getMove() {
        return move;
    }
}
