package com.javarush.task.task08.task0819;

import java.util.HashSet;
import java.util.Set;

/* 
Set из котов
*/

public class Solution {
    public static void main(String[] args) {
        Set<Cat> cats = createCats();

        Cat cat = cats.iterator().next();
        cats.remove(cat);

        printCats(cats);
    }

    public static Set<Cat> createCats() {
        HashSet<Cat> cats = new HashSet<>();

        for (int i = 0; i < 3; i++) {
            cats.add(new Cat());
        }

        return cats;
    }

    public static void printCats(Set<Cat> cats) {
        for (Cat cat: cats)
            System.out.println(cat);
    }

    public static class Cat{

    }
}
