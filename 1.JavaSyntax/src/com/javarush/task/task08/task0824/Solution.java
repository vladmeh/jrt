package com.javarush.task.task08.task0824;

/* 
Собираем семейство
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        ArrayList<Human> children = new ArrayList<>();
        //дети
        Human son1 = new Human("Игорь", true, 2, new ArrayList<>());
        Human son2 = new Human("Миша", true, 3, new ArrayList<>());
        Human daughter = new Human("Яна", false, 4, new ArrayList<>());

        children.add(son1);
        children.add(son2);
        children.add(daughter);

        //родители
        Human mother = new Human("Аня", false, 21, children);
        Human father = new Human("Олег", true, 26, children);

        //родители матери
        ArrayList<Human> chidrenParent1 = new ArrayList<>();
        chidrenParent1.add(mother);
        Human grandMother1 = new Human("Катя", false, 55, chidrenParent1);
        Human grandFather1 = new Human("Петя", true, 56, chidrenParent1);

        //родители отца
        ArrayList<Human> chidrenParent2 = new ArrayList<>();
        chidrenParent2.add(father);
        Human grandMother2 = new Human("Валя", false, 60, chidrenParent2);
        Human grandFather2 = new Human("Вася", true, 66, chidrenParent2);

        System.out.println(grandMother1.toString());
        System.out.println(grandFather1.toString());
        System.out.println(grandMother2.toString());
        System.out.println(grandFather2.toString());
        System.out.println(mother.toString());
        System.out.println(father.toString());
        System.out.println(son1.toString());
        System.out.println(son2.toString());
        System.out.println(daughter.toString());
    }

    public static class Human {
        private String name;
        private Boolean sex;
        private int age;
        private ArrayList<Human> children;

        public Human(String name, boolean sex, int age, ArrayList<Human> children){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }

}
