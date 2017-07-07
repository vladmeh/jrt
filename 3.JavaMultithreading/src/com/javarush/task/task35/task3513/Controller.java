package com.javarush.task.task35.task3513;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @autor mvl on 05.07.2017.
 */
public class Controller extends KeyAdapter {
    private Model model;
    private View view;
    private static final int WINNING_TILE = 2048;

    public Controller(Model model) {
        this.model = model;
        this.view = new View(this);
    }

    public View getView() {
        return view;
    }

    public Tile[][] getGameTiles() {
        return model.getGameTiles();
    }

    public int getScore() {
        return model.score;
    }

    public void resetGame() {
        model.score = 0;
        view.isGameWon = false;
        view.isGameLost = false;
        model.resetGameTiles();
    }

    public void keyPressed(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.VK_ESCAPE) resetGame();
        if (!model.canMove()){
            view.isGameLost = true;
            JOptionPane.showMessageDialog(view, "You've lost :(");
            resetGame();
        }
        if (!view.isGameLost && !view.isGameWon) {
            switch (event.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    model.left();
                    break;
                case KeyEvent.VK_UP:
                    model.up();
                    break;
                case KeyEvent.VK_RIGHT:
                    model.right();
                    break;
                case KeyEvent.VK_DOWN:
                    model.down();
                    break;
            }
        }
        if (model.maxTile == WINNING_TILE){
            view.isGameWon = true;
            JOptionPane.showMessageDialog(view, "You've won!");
            resetGame();
        }
        view.repaint();
    }
}
