package com.javarush.task.task35.task3513;

import java.awt.event.KeyAdapter;

/**
 * @autor mvl on 05.07.2017.
 */
public class Controller extends KeyAdapter{
    private Model model = new Model();

    public Tile[][] getGameTiles(){
        return model.getGameTiles();
    }

    public int getScore(){
        return model.score;
    }
}
