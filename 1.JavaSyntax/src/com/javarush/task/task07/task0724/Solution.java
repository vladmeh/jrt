package com.javarush.task.task07.task0724;

/* 
Семейная перепись

Создай класс Human с полями имя(String), пол(boolean), возраст(int), отец(Human), мать(Human). Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.

Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.

Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…


Требования:
1. Программа не должна считывать данные с клавиатуры.
2. Добавить в класс Human поля: имя(String), пол(boolean), возраст(int), отец(Human), мать(Human).
3. Добавить в класс конструктор public Human(String name, boolean sex, int age).
4. Добавить в класс конструктор public Human(String name, boolean sex, int age, Human father, Human mother).
5. Создай 9 разных объектов типа Human (4 объекта без отца и матери и 5 объектов с ними)).
6. Выведи созданные объекты на экран.
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






















