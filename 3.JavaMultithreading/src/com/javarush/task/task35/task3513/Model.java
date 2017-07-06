package com.javarush.task.task35.task3513;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Model.
 *
 * @autor mvl on 05.07.2017.
 */
public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];

    /**
     *  текущий счет
     */
    int score;

    /**
     * максимальный вес плитки на игровом поле
     */
    int maxTile;

    /**
     * Instantiates a new Model.
     */
    public Model() {
        resetGameTiles();
    }

    /**
     * начальное состояние игры
     */
    public void resetGameTiles() {
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                gameTiles[i][j] = new Tile();
            }
        }

        score = 0;
        maxTile = 2;

        addTile();
        addTile();
    }

    /**
     * смотрит какие плитки пустуют и меняет вес одной из них на 2 или 4
     */
    private void addTile() {
        List<Tile> emptyTiles = getEmptyTiles();
        emptyTiles.get((int) (Math.random() * emptyTiles.size())).value
                = ((Math.random() < 0.9) ? 2 : 4);
    }

    /**
     * возвращает список свободных плиток
     *
     * @return List<Tile>
     */
    private List<Tile> getEmptyTiles() {
        List<Tile> emptyTiles = new ArrayList<>();
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                Tile tile = gameTiles[i][j];
                if (tile.isEmpty()) emptyTiles.add(tile);
            }
        }
        return emptyTiles;
    }

    /**
     * Сжатие плиток, таким образом, чтобы все пустые плитки были справа,
     * т.е. ряд {4, 2, 0, 4} становится рядом {4, 2, 4, 0}
     *
     * @param tiles
     */
    private void compressTiles(Tile[] tiles){
        for (int i = 1; i < tiles.length; i++) {
            for (int j = 1; j < tiles.length; j++) {
                if (tiles[j - 1].isEmpty() && !tiles[j].isEmpty()) {
                    tiles[j - 1] = tiles[j];
                    tiles[j] = new Tile();
                }
            }
        }
    }

    /**
     * Слияние плиток одного номинала, т.е. ряд {4, 4, 2, 0} становится рядом {8, 2, 0, 0}.
     *
     * @param tiles
     */
    private void mergeTiles(Tile[] tiles){
        for (int i = 1; i < tiles.length; i++) {
            if ((tiles[i - 1].value == tiles[i].value) && !tiles[i - 1].isEmpty() && !tiles[i].isEmpty()) {
                tiles[i - 1].value *= 2;
                score += tiles[i - 1].value;
                maxTile = maxTile > tiles[i - 1].value ? maxTile : tiles[i - 1].value;
                tiles[i] = new Tile();
                compressTiles(tiles);
            }
        }
    }
}
