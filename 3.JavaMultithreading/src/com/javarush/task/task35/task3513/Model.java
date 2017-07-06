package com.javarush.task.task35.task3513;

import java.util.ArrayList;
import java.util.Arrays;
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
     * текущий счет
     */
    int score;

    /**
     * максимальный вес плитки на игровом поле
     */
    int maxTile;

    public Tile[][] getGameTiles() {
        return gameTiles;
    }

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
        if (emptyTiles.size() != 0)
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
     * @return boolean
     */
    private boolean compressTiles(Tile[] tiles) {
        boolean compress = false;

        for (int i = 1; i < tiles.length; i++) {
            for (int j = 1; j < tiles.length; j++) {
                if (tiles[j - 1].isEmpty() && !tiles[j].isEmpty()) {
                    compress = true;
                    tiles[j - 1] = tiles[j];
                    tiles[j] = new Tile();
                }
            }
        }

        return compress;
    }

    /**
     * Слияние плиток одного номинала, т.е. ряд {4, 4, 2, 0} становится рядом {8, 2, 0, 0}.
     *
     * @param tiles
     * @return boolean
     */
    private boolean mergeTiles(Tile[] tiles) {
        boolean merge = false;

        for (int i = 1; i < tiles.length; i++) {
            if ((tiles[i - 1].value == tiles[i].value) && !tiles[i - 1].isEmpty() && !tiles[i].isEmpty()) {
                merge = true;
                tiles[i - 1].value *= 2;
                score += tiles[i - 1].value;
                maxTile = maxTile > tiles[i - 1].value ? maxTile : tiles[i - 1].value;
                tiles[i] = new Tile();
                compressTiles(tiles);
            }
        }

        return merge;
    }

    public void left() {
        int j = 0;
        for (Tile[] gameTile : gameTiles)
            if (compressTiles(gameTile) | mergeTiles(gameTile)) j++;

        if (j != 0) addTile();
    }

    public void up(){
        rotate();
        rotate();
        rotate();
        left();
        rotate();
    }

    public void right(){
        rotate();
        rotate();
        left();
        rotate();
        rotate();

    }

    public void down(){
        rotate();
        left();
        rotate();
        rotate();
        rotate();
    }

    /**
     * классический поворот двумерного массива по часовой стрелке
     */
    private void rotate() {
        Tile[][] rotateGameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++)
        {
            for (int j = 0; j < FIELD_WIDTH; j++)
            {
                rotateGameTiles[j][FIELD_WIDTH-1-i] = gameTiles[i][j];
            }
        }
        gameTiles = rotateGameTiles;
    }

    public boolean canMove(){
        if (!getEmptyTiles().isEmpty())
            return true;

        for (Tile[] gameTile : gameTiles) {
            for (int j = 1; j < gameTiles.length; j++) {
                if (gameTile[j].value == gameTile[j - 1].value)
                    return true;
            }
        }

        for(int j = 0; j < gameTiles.length; j++) {
            for(int i = 1; i < gameTiles.length; i++) {
                if(gameTiles[i][j].value == gameTiles[i-1][j].value)
                    return true;
            }
        }

        return false;
    }

    /*public static void main(String[] args) {
        Model model = new Model();
        printModel(model);

        model.left();
        System.out.println("\nleft");
        printModel(model);

        model.up();
        System.out.println("\nup");
        printModel(model);

        model.right();
        System.out.println("\nright");
        printModel(model);

        model.down();
        System.out.println("\ndown");
        printModel(model);
    }

    private static void printModel(Model model) {
        for (Tile[] gameTile : model.gameTiles) {
            for (Tile tile : gameTile) {
                System.out.printf("[%d]", tile.value);
            }
            System.out.println();
        }
    }*/
}
