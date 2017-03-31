package com.javarush.task.task15.task1530;

/**
 * Created by vlad on 31.03.2017.
 */
public abstract class DrinkMaker {
    //выбрать подходящую чашку
    public abstract void getRightCup();

    //положить ингредиенты
    public abstract void putIngredient();

    //залить жидкостью
    public abstract void pour();

    public void makeDrink(){
        getRightCup();
        putIngredient();
        pour();
    }
}
