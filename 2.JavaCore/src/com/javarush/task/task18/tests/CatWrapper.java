package com.javarush.task.task18.tests;

/**
 * Created by vlad on 20.04.2017.
 */
public class CatWrapper extends Cat {

    private Cat original;

    public CatWrapper (Cat cat)
    {
        this.original = cat;
    }

    public String getName()
    {
        return "Кот по имени " + original.getName();
    }

    public void setName(String name)
    {
        original.setName(name);
    }

    public static void main(String[] args) {
        Cat cat = new Cat("Васька ");
        Cat catWrap = new CatWrapper (cat);
        printName(catWrap);
    }

    public static void printName(Cat named)
    {
        System.out.println(named.getName());
    }
}
