package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

public class Solution {
    public static void main(String[] args) {
        Human grandMother1 = new Human("Катя", false, 55);
        Human grandFather1 = new Human("Петя", true, 56);
        Human grandMother2 = new Human("Валя", false, 60);
        Human grandFather2 = new Human("Вася", true, 66);
        Human mother = new Human("Аня", false, 21, grandFather1, grandMother1);
        Human father = new Human("Олег", true, 26, grandFather2, grandMother2);
        Human son1 = new Human("Игорь", true, 2, father, mother);
        Human son2 = new Human("Миша", true, 3, father, mother);
        Human daughter = new Human("Яна", false, 4, father, mother);

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
        private boolean sex;
        private int age;
        private Human father;
        private Human mother;

        public Human(String name, boolean sex, int age){
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, boolean sex, int age, Human father, Human mother){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }
}






















