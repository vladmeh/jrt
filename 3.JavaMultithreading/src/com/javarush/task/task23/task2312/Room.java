package com.javarush.task.task23.task2312;

/**
 * Created by mvl on 24.05.2017.
 */
public class Room {
    private int width, height;
    private Snake snake;
    private Mouse mouse;

    public static Room game;


    public Room(int width, int height, Snake snake) {
        this.width = width;
        this.height = height;
        this.snake = snake;
    }

    public static void main(String[] args) {
        Snake snake = new Snake(5, 6);
        snake.setDirection(SnakeDirection.DOWN);
        game = new Room(10, 10, snake);
    }

    public void createMouse(){
        int x = (int)(Math.random() * width);
        int y = (int)(Math.random() * height);

        setMouse(new Mouse(x,y));
    }

    public void eatMouse(){
        createMouse();
    }

    public void run(){}
    public void print(){}

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Snake getSnake() {
        return snake;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public Mouse getMouse() {
        return mouse;
    }

    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }
}
